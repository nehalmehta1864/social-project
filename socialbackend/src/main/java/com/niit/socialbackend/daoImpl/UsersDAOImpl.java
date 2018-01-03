package com.niit.socialbackend.daoImpl;

import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialbackend.dao.UsersDAO;
import com.niit.socialbackend.model.Users;


@Repository("userDAO")
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UsersDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	 @Transactional
		public ArrayList<Users> getAllUser() {
			
			String hql = "from Users";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);		
			return (ArrayList<Users>) query.list();
			
		}
	  @Transactional
	  public boolean saveUser(Users user) {
	  	
	  	try {
	  		sessionFactory.getCurrentSession().save(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
	  }
	  
	  @Transactional	  
	public boolean updateOnlineStatus(Users user) {
		try{
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
		
	}
	  
	@Transactional 
	public Users getUser(int userid) {
		
		System.err.println(userid);
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where userid="+userid);
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}
	
	
	@Transactional 
	public Users getUserbyId(int userid) {
		
		
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where userid="+userid);
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}

	public boolean checkLogin(Users user) {
		try{
			Session session=sessionFactory.openSession();
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			Query query=session.createQuery("from Users where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'");
			
			Users user1=(Users)query.list().get(0);
			
			if(user1==null)
			{
				
				return false;
			}
			else
			{
				System.out.println("2.."+user1.getEmail());
				System.out.println("2..."+user1.getPassword());
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}
	}
	public Users getUserbyemail(String email) {
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where email='"+email+"'");
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}


	
	

}
/*package com.niit.socialbackend.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialbackend.dao.UsersDAO;
import com.niit.socialbackend.model.Users;
@Repository("userDAO")
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UsersDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}

		
	  @Transactional
	  public boolean addUser(Users user) {
	  	
	  	try {
	  		sessionFactory.getCurrentSession().save(user);
	  		return true;
	  	} catch (HibernateException e) {
	  	
	  		e.printStackTrace();
	  		return false;
	  	}
	  }
	  
	  @Transactional	  
	public boolean updateOnlineStatus(Users user) {
		try{
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
		
	}
	  
	@Transactional 
	public Users getUser(int userid) {
		
		System.err.println(userid);
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where userid="+userid);
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}
	
	
	@Transactional 
	public Users getUserbyId(int userid) {
		
		
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where userid="+userid);
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}

	public boolean checkLogin(Users user) {
		try{
			Session session=sessionFactory.openSession();
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			Query query=session.createQuery("from Users where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'");
			
			Users user1=(Users)query.list().get(0);
			
			if(user1==null)
			{
				
				return false;
			}
			else
			{
				System.out.println("2.."+user1.getEmail());
				System.out.println("2..."+user1.getPassword());
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}
	}
	public Users getUserbyemail(String email) {
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where email='"+email+"'");
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}
	public List<Users> getAllUsers() {
			String hql = "from Users";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);		
		return (List<Users>) query.list();
		
	
	}


	

}
*/