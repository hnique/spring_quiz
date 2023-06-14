package com.quiz.lesson01;

public class Forum {
	// field
	private String title;
	private String user;
	private String content;
	
	// constructor
	public Forum() {}
	
	public Forum(String title, String user, String content) {
		super();
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	// getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
