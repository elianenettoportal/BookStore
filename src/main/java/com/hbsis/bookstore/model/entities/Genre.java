package com.hbsis.bookstore.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@Table(name = "genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = -7497379530223277900L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idgenre;

	@Column(name="description")
	private String description;

	@JsonIgnore
	@ManyToMany(mappedBy = "genre")
	private List<Book> book;

	public Genre() {
	}

	public Long getIdgenre() {
		return this.idgenre;
	}

	public void setIdgenre(Long idgenre) {
		this.idgenre = idgenre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBook() {
		return this.book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}



}