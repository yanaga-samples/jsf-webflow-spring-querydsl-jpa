package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Profile("teste")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Teste {

}