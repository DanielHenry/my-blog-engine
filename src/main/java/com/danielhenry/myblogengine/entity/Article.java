package com.danielhenry.myblogengine.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Article {

    private @Id @GeneratedValue Long id;
	private String title;
	private String content;

	Article(String title, String content) {
		this.title = title;
		this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}