package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data.ListQueryDslJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, ListQueryDslJpaRepository<Pessoa>, PessoaRepositoryCustom{
}
