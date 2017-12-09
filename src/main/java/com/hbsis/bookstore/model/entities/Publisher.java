package com.hbsis.bookstore.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {
	private static final long serialVersionUID = -7497379530223277900L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idpublisher;

	@Column(name="company_name")
	private String companyName;

	@Column(name="publisher_name")
	private String publisherName;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
	private List<Book> book;
	
	public Publisher() {
	}

	public Long getIdpublisher() {
		return this.idpublisher;
	}

	public void setIdpublisher(Long idpublisher) {
		this.idpublisher = idpublisher;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}


	

}