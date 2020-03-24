package com.briup.buke.bean;

import io.swagger.annotations.ApiModelProperty;

public class ReaderPack {
	@ApiModelProperty(value="读者ID")
	private Integer id;
	@ApiModelProperty(value="读者标识名")
	private String username;
	@ApiModelProperty(value="读者密码")
	private String password;
	@ApiModelProperty(value="读者邮箱")
	private String email;
	public ReaderPack() {
		super();
	}
	public ReaderPack(Integer id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ReaderPack [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
