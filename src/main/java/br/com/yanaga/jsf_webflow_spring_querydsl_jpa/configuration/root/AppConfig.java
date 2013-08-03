package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data.NonTransactionalQuerydslJpaRepositoryFactoryBean;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableSpringConfigured
@EnableJpaRepositories(basePackages = "br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app", repositoryFactoryBeanClass = NonTransactionalQuerydslJpaRepositoryFactoryBean.class)
@ComponentScan(basePackages = {"br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app",
                               "br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root"}, excludeFilters =
                                                                                                    @Filter(Controller.class))
@Configuration
public class AppConfig{

    @Autowired
    private DataSource dataSource;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
