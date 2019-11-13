package com.casestudy.jatin.chander.model;

import javax.persistence.CascadeType;
//Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMENT_ID")
	private long commentId;
	@Column(name = "COMMENT_TEXT")
	private String description;
	// Many comments for one post
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	private Post post;
	// Many comments can belong to one user

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "USER_COMMENTS", joinColumns = { @JoinColumn(name = "COMMENT_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "USER_ID") })
	@JoinColumn(name = "USER_ID")
	private UserProfile user;

	// Getters & Setters
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
