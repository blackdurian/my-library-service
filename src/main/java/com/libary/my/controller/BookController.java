package com.libary.my.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libary.my.entity.Book;
import com.libary.my.exception.LibraryServiceException;
import com.libary.my.model.BookRegistrationRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.libary.my.service.BookService;

@Slf4j
@RestController
public class BookController {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private BookService bookService;

	@ResponseBody
	@GetMapping("book/all")
	public List<Book> getAll() {
		return bookService.getAllBooks();
	}

	@ResponseBody
	@PostMapping(value = "book", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book registerBook(@RequestBody BookRegistrationRequest request) throws LibraryServiceException, JsonProcessingException {
		log.debug("registerBook:  {}",  objectMapper.writeValueAsString(request));
		return bookService.registerBook(request);
	}
}
