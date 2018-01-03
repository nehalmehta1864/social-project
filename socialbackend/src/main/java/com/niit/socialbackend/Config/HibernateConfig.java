package com.niit.socialbackend.Config;
import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.socialbackend.dao.BlogCommentDAO;
import com.niit.socialbackend.dao.BlogDAO;
import com.niit.socialbackend.dao.UsersDAO;
import com.niit.socialbackend.daoImpl.BlogCommentDAOImpl;
import com.niit.socialbackend.daoImpl.BlogDAOImpl;
import com.niit.socialbackend.daoImpl.UsersDAOImpl;
import com.niit.socialbackend.model.Blog;
import com.niit.socialbackend.model.BlogComments;
import com.niit.socialbackend.model.Users;


@Configuration
@ComponentScan("com.niit.socialbackend")
@EnableTransactionManagement
public class HibernateConfig 
{
	@Autowired
	    @Bean(name="sessionFactory")
	    public SessionFactory sessionFactory(DataSource dataSource)  {
	        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);

	        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
	        
	        sessionBuilder.addProperties(getHibernateProperties());
	     
	       sessionBuilder.addAnnotatedClass(Users.class);
	       sessionBuilder.addAnnotatedClass(Blog.class);
	       sessionBuilder.addAnnotatedClass(BlogComments.class);
	   
	        return sessionBuilder.buildSessionFactory();
	    }
	 @Autowired
	    @Bean(name = "datasource") 
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/socialproject");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        System.out.println("Data Source Created.....");
	        return dataSource;

	       
	        }

	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	  
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.connection.autocommit", true);
	        return properties;
	    }

	    
	    
	    @Autowired
	    @Bean(name="transactionManager")
	     
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }
	        

	    
	    @Autowired    
	    @Bean(name="userDAO")
		public UsersDAO getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new UsersDAOImpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="BlogDAO")
		public BlogDAO getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("BLog DAO object Created");
			return new BlogDAOImpl(sessionFactory);
		}
	    @Autowired    
	    @Bean(name="BlogCommentDAO")
		public BlogCommentDAO getBlogCommentDAOImpl(SessionFactory sessionFactory)
		{
			System.out.println("BLogCOmments DAO object Created");
			return new BlogCommentDAOImpl(sessionFactory);
		}
	    
	   
	    
}