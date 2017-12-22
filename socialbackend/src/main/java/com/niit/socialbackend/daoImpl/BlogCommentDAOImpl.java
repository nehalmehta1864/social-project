package com.niit.socialbackend.daoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialbackend.dao.BlogCommentDAO;
import com.niit.socialbackend.model.Blog;
import com.niit.socialbackend.model.BlogComments;

public class BlogCommentDAOImpl implements BlogCommentDAO  {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

@Transactional
	public boolean addBlogComment(BlogComments blogcomment) {
		try
		{
		sessionFactory.getCurrentSession().save(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}

		
	}
@Transactional
public BlogComments getBlogComment(int commentId)
{
	Session session=sessionFactory.openSession();
	BlogComments blogcomment = (BlogComments) session.get(BlogComments.class, commentId);
	session.close();
	return blogcomment;
	
}

@Transactional
	public boolean deleteBlogComment(BlogComments blogcomment) {
		try
		{
		sessionFactory.getCurrentSession().delete(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}

		
	}
@Transactional
	public boolean updateBlogComment(BlogComments blogcomment) {
		try
		{
		sessionFactory.getCurrentSession().update(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}

		
	}


@Transactional
public ArrayList<BlogComments> getAllBlogComments(int blogid) {
	Session ssn=sessionFactory.openSession();
	
	
	org.hibernate.Query q= ssn.createQuery("from BlogComments where blogid="+blogid);
	ArrayList<BlogComments> l=(ArrayList<BlogComments>) q.list();
	
    
    ssn.close();


	
	return l;
	
}

@Transactional
public boolean incview(int blogid) {
	try
	{
		Session session=sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogid);
		
		session.update(blog);
		
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}	
}


@Transactional
public ArrayList<Blog> getAllBlogRequests()
{
	
	Session session = sessionFactory.openSession();
	ArrayList<Blog> blogreq=(ArrayList<Blog>)session.createQuery("from Blog where status='A'").list();
	session.close();
	return blogreq;	
	
}

@Transactional
public boolean like(int blogid) {
	
	try
	{
		Session session=sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogid);
		
		session.update(blog);
		
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
	
	
	
}
@Transactional
public boolean dislike(int blogid) {
	try
	{
		Session session=sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogid);
		blog.setLikes(blog.getDislikes()+1);
		session.update(blog);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
	
	
}


}
