package com.hbsis.bookstore.resources;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.hbsis.bookstore.model.entities.Book;

public interface BookResource {

	ResponseEntity<List<Book>> list();

	ResponseEntity<Book> get(Long id);
	
	ResponseEntity<Book> create(Book book);

	ResponseEntity<Book> update(Book book);

	ResponseEntity<Book> delete(Long id);
}
