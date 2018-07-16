package com.obbo.cloud.docservice.model;

import java.util.UUID;

public class Document {

	private UUID id;
	private String title;
	private String owner;

	public Document() {
		super();
	}

	public Document(UUID id, String title, String owner) {
		super();
		this.id = id;
		this.title = title;
		this.owner = owner;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
