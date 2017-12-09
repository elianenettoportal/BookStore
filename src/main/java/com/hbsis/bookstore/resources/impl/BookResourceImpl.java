package com.hbsis.bookstore.resources.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hbsis.bookstore.model.entities.Book;
import com.hbsis.bookstore.resources.BookResource;
import com.hbsis.bookstore.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "/api/v1/books", tags = { "book" })
@RestController
@RequestMapping(value = "/api/v1/book")
public class BookResourceImpl implements BookResource {

	@Autowired
	private BookService service;
	
	@ApiOperation(value = "Retrieves a list of book", tags = { "book" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of venues", responseContainer = "List", response = Book.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list() {
		List<Book> book = service.list();
		
		if (book.isEmpty())
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);

		
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "Get a venue by id", tags = { "book" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a venue searched by id", response = Book.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> get(@ApiParam(value = "Book Id", required = true) @PathVariable("id") Long id) {
		Book book = service.get(id);

		if (null == book)
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	

	@ApiOperation(value = "Update a book resource", tags = { "book" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created book resource", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no book was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Book> create(@ApiParam(value = "Book json stream resource", required = true, name = "book") @Valid @RequestBody Book book) {
		Book created = service.insert(book);

		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		
		return new ResponseEntity<Book>(created, HttpStatus.CREATED);

	}
	@ApiOperation(value = "Update a Book resource", tags = { "book" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated Book resource", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Book> update(@ApiParam(value = "Book json stream resource", required = true) @RequestBody Book book) {
		
		Book persisted = service.update(book);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Book>(persisted, HttpStatus.OK);
	}
	

	@ApiOperation(value = "Delete a Book resource", tags = { "book" }, code = 204)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content retrieve, deleted Book resource", response = Book.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no delete was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> delete(@ApiParam(value = "Book Id", required = true) @PathVariable("id") Long id) {
		
		Book persisted = service.delete(id);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
