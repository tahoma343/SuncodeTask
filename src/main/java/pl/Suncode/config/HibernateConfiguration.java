package pl.Suncode.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	public ApplicationContext context;
	
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factorySessionBean = new LocalSessionFactoryBean();
		factorySessionBean.setConfigLocation(context.getResource("classpath:spring-framework/hibernate.cfg.xml"));
		factorySessionBean.setDataSource(dataSource);
		factorySessionBean.setAnnotatedClasses(pl.Suncode.model.SuncodeEntity.class);
		return factorySessionBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}


