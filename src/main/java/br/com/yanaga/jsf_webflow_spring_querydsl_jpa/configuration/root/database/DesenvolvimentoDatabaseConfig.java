package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root.database;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root.annotation.Desenvolvimento;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Desenvolvimento
@Configuration
public class DesenvolvimentoDatabaseConfig implements DatabaseConfig{

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceUnitName("mysql");
        return factoryBean;
    }

    @Bean
    @Override
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/webflow");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setMaxActive(100);
        dataSource.setMaxIdle(10);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
}
