package com.hbsis.bookstore.service;

import java.util.List;
import com.hbsis.bookstore.model.entities.Book;

public interface BookService {
	
	List<Book> list();

	Book get(Long id);
	
	Book insert(Book book);

	Book update(Book book);

	Book delete(Long id);


}
