package com.casestudy.jatin.chander.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javassist.SerialVersionUID;

@Entity @IdClass(value = AuthoritiesId.class)
// Achieves the same as extra class
//@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = {"authority", "username"}))
@Table(name = "authorities")
public class Authorities {
	@Id
	@Column(name = "authority")
	private String authority;
	@Id
	@ManyToOne()
	@JoinColumn(name = "username")
	private Credential user;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credential getUser() {
		return user;
	}

	public void setUser(Credential user) {
		this.user = user;
	}

}


class AuthoritiesId implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "authority")
	private String authority;
	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private Credential user;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credential getUser() {
		return user;
	}

	public void setUser(Credential user) {
		this.user = user;
	}

}

