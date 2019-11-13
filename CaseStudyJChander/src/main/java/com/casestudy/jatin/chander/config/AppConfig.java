package com.casestudy.jatin.chander.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan("com.sec")
//@EnableJpaRepositories("com.sec.dao")
public class AppConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		Properties properties = new Properties();
		
		//JDBC Properties
		properties.put(DRIVER, env.getProperty("jdbc.driver"));
		properties.put(URL, env.getProperty("jdbc.url"));
		properties.put(USER, env.getProperty("jdbc.username"));
		properties.put(PASS, env.getProperty("jdbc.password"));
		
		//Hibernate Properties
		properties.put(DIALECT, env.getProperty("hibernate.dialect"));
		properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		properties.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(ENABLE_LAZY_LOAD_NO_TRANS, env.getProperty("hibernate.enable_lazy_load_no_trans"));
		
		factoryBean.setHibernateProperties(properties);
		factoryBean.setPackagesToScan("com.mycasestudy");

		
		return factoryBean;
	}
	
	
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionalManager = new HibernateTransactionManager();
		transactionalManager.setSessionFactory(getSessionFactory().getObject());
		return transactionalManager;
	}
	
}