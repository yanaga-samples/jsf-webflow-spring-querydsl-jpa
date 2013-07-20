package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PessoaRepositoryImpl implements PessoaRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pessoa> consultaComplexa(){
        JPAQuery query = new JPAQuery(entityManager);
        QPessoa qPessoa = QPessoa.pessoa;
        QEndereco qEndereco = QEndereco.endereco1;
        return query.from(qPessoa).join(qPessoa.enderecos, qEndereco).where(qEndereco.endereco.containsIgnoreCase("t")).list(qPessoa);
    }
}
