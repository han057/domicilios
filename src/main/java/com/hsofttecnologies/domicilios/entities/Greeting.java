package com.hsofttecnologies.domicilios.entities;

public class Greeting {

	private int id;
	private String content;

	public Greeting(int id, String content) {
		super();
		this.content = content;
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
