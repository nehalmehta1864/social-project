package com.niit.socialbackend.daoImpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialbackend.dao.BlogDAO;
import com.niit.socialbackend.model.Blog;
import com.niit.socialbackend.model.BlogComments;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean addBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
@Transactional
	public boolean updateBlog(Blog blog) {
		
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
@Transactional
	public boolean deleteBlog(Blog blog) {
	
		try
		{
		sessionFactory.getCurrentSession().delete(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
@Transactional
	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogId);
		session.close();
		return blog;
		
	}
@Transactional
	public ArrayList<Blog> getAllBlogs() {
	
		Session session = sessionFactory.openSession();
		ArrayList<Blog> blogList=(ArrayList<Blog>)session.createQuery("from Blog where status='YES'").list();
		session.close();
		return blogList;
	}
@Transactional
	public boolean approveBlog(Blog blog) {
		
		try{
			blog.setStatus("Y");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			
		}
		catch(Exception e)
		{
		
		return false;
		}
	}
@Transactional
	public boolean rejectBlog(Blog blog) {
		try{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			
		}
		catch(Exception e)
		{
		
		return false;
		}
		

}




}