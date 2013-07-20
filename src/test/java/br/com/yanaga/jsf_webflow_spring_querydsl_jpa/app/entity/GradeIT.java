package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.configuration.root.AppConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class GradeIT {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeTransaction
	public void setUp() {
		// JdbcTestUtils.executeSqlScript(jdbcTemplate, applicationContext,
		// "classpath:insert.sql", false);
	}

	@AfterTransaction
	public void tearDown() {
		// JdbcTestUtils.executeSqlScript(jdbcTemplate, applicationContext,
		// "classpath:delete.sql", false);
	}

	@Test
	public void test() {
	}

}
