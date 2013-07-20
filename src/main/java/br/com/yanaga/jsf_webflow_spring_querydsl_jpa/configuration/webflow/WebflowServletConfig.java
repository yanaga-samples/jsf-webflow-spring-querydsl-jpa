package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.webflow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app", scopedProxy = ScopedProxyMode.TARGET_CLASS, useDefaultFilters = false, includeFilters = {
		@Filter(Controller.class), @Filter(Configuration.class) })
@ImportResource("classpath*:META-INF/spring/servlet/webflow-servlet.xml")
public class WebflowServletConfig extends WebMvcConfigurerAdapter {

}