package com.niit.socialbackend.dao;

import java.util.ArrayList;

import com.niit.socialbackend.model.Blog;
import com.niit.socialbackend.model.BlogComments;

public interface BlogCommentDAO {
	public boolean addBlogComment(BlogComments blogcomment);
	public boolean deleteBlogComment(BlogComments blogcomment);
	public boolean updateBlogComment(BlogComments blogcomment);
	public BlogComments getBlogComment(int commentId);
	public ArrayList<BlogComments> getAllBlogComments(int blogid);
	public boolean like(int blogid);
	public boolean dislike(int blogid);
	public boolean incview(int blogid);
	public ArrayList<Blog> getAllBlogRequests();
	
}
