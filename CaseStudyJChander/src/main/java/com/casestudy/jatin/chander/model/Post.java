package com.casestudy.jatin.chander.model;

import java.util.HashSet;
//Imports
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	private long postId;
//	@Column(name = "IMAGE_URL", nullable = false)
//	private String imageURL;
	@Column(name = "POST_TITLE", nullable = false)
	private String postTitle;
	@Column(name = "POST_DESC")
	private String postDescription;
	// Many posts can belong to one user
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserProfile user;
	// One post can have many comments
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	// One post can have many categories
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
	private Set<Categories> categories = new HashSet<>();
//	@ElementCollection(targetClass = Type.class)
//	@JoinTable(name = "POST_CATEGORIES",
//	joinColumns = @JoinColumn(name = "POST_ID"))
//	@Column(name = "POST_TYPE", nullable = false)
//	@Enumerated(EnumType.STRING)
//	private Set<Type> postTypes;

	// Getters & Setters
	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}
	
//	public String getImageURL() {
//		return imageURL;
//	}
//
//	public void setImageURL(String imageURL) {
//		this.imageURL = imageURL;
//	}
	
	
	
//	public String getPostTitle() {
//		return postTitle;
//	}
//
//	public void setPostTitle(String postTitle) {
//		this.postTitle = postTitle;
//	}

	public String getPostDescription() {
		return postDescription;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}
	
//	public Set<Type> getPostTypes() {
//		return postTypes;
//	}
//
//	public void setPostTypes(Set<Type> postTypes) {
//		this.postTypes = postTypes;
//	}

}
