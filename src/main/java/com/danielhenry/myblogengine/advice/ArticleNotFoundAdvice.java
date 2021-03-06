package com.danielhenry.myblogengine.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.danielhenry.myblogengine.exception.ArticleNotFoundException;

@ControllerAdvice
class ArticleNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ArticleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String articleNotFoundHandler(ArticleNotFoundException ex) {
		return ex.getMessage();
	}
}