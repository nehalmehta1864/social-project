package com.niit.socialbackend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.socialbackend.dao.BlogCommentDAO;
import com.niit.socialbackend.model.BlogComments;

 @Repository("blogCommentsDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	@Autowired
	SessionFactory sessionFactory;
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	public boolean deleteBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public BlogComments getBlogComments(int blogCommentsId) {

		Session session = sessionFactory.openSession();
		BlogComments blogComments = (BlogComments) session.get(BlogComments.class, new Integer(blogCommentsId));
		return blogComments;

	}
	@Transactional
	public List<BlogComments> getAllBlogComments() {

		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

}