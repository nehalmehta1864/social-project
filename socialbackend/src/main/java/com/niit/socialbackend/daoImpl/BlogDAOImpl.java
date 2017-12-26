package com.niit.socialbackend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.socialbackend.dao.BlogDAO;
import com.niit.socialbackend.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public Blog getBlog(int blogId) {
		Session session = sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, new Integer(blogId));
		return blog;
	}

	@Transactional
	public List<Blog> getAllBlogs() {

		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}

	@Transactional
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}
	@Transactional
	public boolean incrementLike(Blog blog) {
		try {
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

}