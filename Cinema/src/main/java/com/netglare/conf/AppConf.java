package com.netglare.conf;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.netglare")
public class AppConf {
	
	@Autowired
	Environment env;
	
	@Bean
    public ViewResolver viewResolver() {	
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver; 
	}

	
	
	
	
	@Bean
	DataSource dataSource() {
		
		ComboPooledDataSource cds = new ComboPooledDataSource();
		try {
			cds.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cds.setJdbcUrl(env.getProperty("jdbc:mysql://localhost:3306/sakila?useSSL=false"));
		cds.setUser(env.getProperty("jdbc.user"));
		cds.setPassword(env.getProperty("jdbc.password"));
		cds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		cds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		cds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		cds.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		return cds;
	}

	@Bean
	LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		
        properties.put("hibernate.dialect",env.getProperty("hibernate.dialect") );
        properties.put("hibernate.show_sql",env.getProperty("hibernate.show_sql") );
        properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto") );
        
        sf.setDataSource(dataSource());
        sf.setHibernateProperties(properties);
		
		return sf;
	}
	
	@Bean
	HibernateTransactionManager transactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm;
	}


}
