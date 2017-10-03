package com.niit.MobileShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niit.MobileShoppingBackend.DTO"})//it will scan from the base package as given 
@EnableTransactionManagement//it will enable the transaction from the class to database
public class hibernateConfig {
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/mobileshopping";//data base url
	private final static String DATABASE_DRIVER="org.h2.Driver";//database driver is enales the application to interact with the data base
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";//it will generate the data base specific query for that data base 
	private final static String DATABASE_USERNAME="MobileShopping";//username for the data base 
	private final static String DATABASE_PASSWORD="";//password for the database username
	//DataSource bean
	@Bean("dataSource")
	public DataSource getDataSource(){//DataSource is a return type of the getDataSource
		BasicDataSource dataSource=new BasicDataSource();//creating and initializing the BasicDataSource class
		//providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	//SessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)//it will get DataSource
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		//providing the hibernate properties
		builder.addProperties(getHibernateProperties());//this method which is in the parameter of the properties method is given below
		builder.scanPackages("com.niit.MobileShoppingBackend.DTO");//to get entities provided the base package in this package all that entity will be store
		
		
		
		
		
		return builder.buildSessionFactory();//return instance of the SessionFactory
	}
	//all the hibernate properties
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);//providing the database dialect info here 
		properties.put("hibernate.show_sql", "true");//it will be used for showing the sql query which is passing.
		properties.put("hibernate.show_format", "true");//
		return properties;
	}
	//HibernateTransactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	
		return transactionManager;
	}
}
