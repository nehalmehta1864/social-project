package com.niit.socialbackend.dao;

import java.util.ArrayList;

import com.niit.socialbackend.model.Blog;

import com.niit.socialbackend.model.Users;



public interface BlogDAO {
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public ArrayList<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	
}