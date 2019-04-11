package com.danielhenry.myblogengine.exception;

public class ArticleNotFoundException extends RuntimeException {

	ArticleNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}