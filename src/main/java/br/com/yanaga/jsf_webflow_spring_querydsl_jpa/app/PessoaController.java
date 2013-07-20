package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PessoaController{

    @Autowired
    PessoaRepository pessoaRepository;

    public Filtro newFiltro(){
        return new Filtro();
    }

    public List<Pessoa> filtrar(Filtro filtro){
        return pessoaRepository.consultaComplexa();
    }

    public Pessoa newPessoa(){
        return Pessoa.newInstance();
    }

    public Endereco newEndereco(Pessoa pessoa){
        return Endereco.newInstance(pessoa);
    }

    public void salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public static class Filtro implements Serializable{

        private String value;

        public String getValue(){
            return value;
        }

        public void setValue(String value){
            this.value = value;
        }

        public Predicate toPredicate(){
            BooleanBuilder builder = new BooleanBuilder();
            if(!Strings.isNullOrEmpty(value)) {
                QPessoa qPessoa = QPessoa.pessoa;
                builder.and(qPessoa.razao.containsIgnoreCase(value));
            }
            return builder;
        }
    }
}
