package com.briup.buke.bean;

public class CategoryPack {
	private Long id;
	private Long code;
	private String name;

	public CategoryPack(Long id, Long code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public CategoryPack() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "CategoryPack [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
	
}
