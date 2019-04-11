package com.danielhenry.myblogengine.exception;

public class ArticleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public ArticleNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}