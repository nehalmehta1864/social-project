package com.niit.socialbackend.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity

@Table(name="BlogComments")
public class BlogComments  {

	/**
	 * 
	 */
	
	@Id
    @GeneratedValue 
    @Column(name = "BlogcomId", nullable = false)
	private int blogcomid;
	
	@Column(name = "BlogComm", nullable = false)
    private String blogcomm;
	


	@Column(name = "Blogid", nullable = false)
	private int blogid;
	
	@Column(name = "Userid", nullable = false)
	private int userid;
	
	
	
	

	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBlogcomid() {
		return blogcomid;
	}
	public String getBlogcomm() {
		return blogcomm;
	}
	public void setBlogcomm(String blogcomm) {
		this.blogcomm = blogcomm;
	}
	public void setBlogcomid(int blogcomid) {
		this.blogcomid = blogcomid;
	}


}