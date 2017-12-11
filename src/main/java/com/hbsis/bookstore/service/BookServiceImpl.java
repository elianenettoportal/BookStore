package com.hbsis.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsis.bookstore.model.entities.Book;
import com.hbsis.bookstore.repository.BookRepository;
import com.hbsis.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	public List<Book> list() {
		return repository.findAll();
	}

	public Book get(Long id) {
		return repository.findOne( id );
	}

	public Book insert(Book book) {
		return repository.save( book );
	}

	public Book update(Book book) {
		Book persisted = repository.findOne(book.getIdbook());

		if (null == persisted)
			return null;
		
		persisted.setAuthor( book.getAuthor());
		persisted.setCost(book.getCost());
		persisted.setCreateDate(book.getCreateDate());
		persisted.setDescription(book.getDescription());
		persisted.setGenre(book.getGenre());
		persisted.setIsbn(book.getIsbn());
		persisted.setPublisher(book.getPublisher());
		persisted.setTitle(book.getTitle());

		return repository.save(persisted);
	}

	public Book delete(Long id) {
		Book persisted = repository.findOne( id );

		if (null == persisted)
			return null;
		
		repository.delete( persisted );
		return persisted;
	}

}
