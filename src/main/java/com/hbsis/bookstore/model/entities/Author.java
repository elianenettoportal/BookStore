package com.hbsis.bookstore.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "author")
@NamedQuery(name="Author.findAll", query="SELECT s FROM Author s")
public class Author implements Serializable {
	private static final long serialVersionUID = -7497379530223277900L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idauthor;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "author")
	private List<Book> book;

	public Author() {
	}

	public Long getIdauthor() {
		return this.idauthor;
	}

	public void setIdauthor(Long idauthor) {
		this.idauthor = idauthor;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	

}