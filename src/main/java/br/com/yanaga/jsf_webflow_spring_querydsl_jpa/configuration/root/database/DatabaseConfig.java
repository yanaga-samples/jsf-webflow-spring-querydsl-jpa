package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root.database;

import javax.sql.DataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public interface DatabaseConfig {

	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception;

	public DataSource dataSource();

}