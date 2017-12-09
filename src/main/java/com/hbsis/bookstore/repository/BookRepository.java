package com.hbsis.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hbsis.bookstore.model.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE b.idbook = :idbook")
	Book findByIdBook(@Param("idbook") Long idbook);
	
	@Query("SELECT b FROM Book b")
	List<Book> findBook();
}
