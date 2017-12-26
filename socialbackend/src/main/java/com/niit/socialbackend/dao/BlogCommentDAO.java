package com.niit.socialbackend.dao;

import java.util.List;

import com.niit.socialbackend.model.BlogComments;

public interface BlogCommentDAO {
	public boolean saveBlogComments(BlogComments blogComments);

	public boolean deleteBlogComments(BlogComments blogComments);

	public boolean updateBlogComments(BlogComments blogComments);

	public BlogComments getBlogComments(int blogCommentsId);

	public List<BlogComments> getAllBlogComments();
}