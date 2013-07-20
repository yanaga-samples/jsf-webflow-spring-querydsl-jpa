package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import java.util.List;

public interface PessoaRepositoryCustom{

    public List<Pessoa> consultaComplexa();
}
