package com.hbsis.bookstore.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Book.findAll", query="SELECT v FROM Book v")
public class Book implements Serializable {
	private static final long serialVersionUID = -7497379530223277900L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idbook;

	@Column(name="cost")
	private BigDecimal cost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="description")
	private String description;

	@Column(name="isbn")
	private Long isbn;

	@Column(name="title")
	private String title;

	@ManyToMany
	@JoinTable(name = "book_author", 
				joinColumns = {@JoinColumn(name = "idbook", referencedColumnName="idbook") },
				inverseJoinColumns = {@JoinColumn(name = "idauthor", referencedColumnName="idauthor") })	
	private List<Author> author;	
	
	@ManyToMany
	@JoinTable(name = "book_genre", 
				joinColumns = {@JoinColumn(name = "idbook", referencedColumnName="idbook") },
				inverseJoinColumns = {@JoinColumn(name = "idgenre", referencedColumnName="idgenre") })	
	private List<Genre> genre;	

	@ManyToOne //@OneToOne
	@JoinColumn(name = "idpublisher", nullable = false)
	private Publisher publisher;


	public Book() {
	}

	public Long getIdbook() {
		return this.idbook;
	}

	public void setIdbook(Long idbook) {
		this.idbook = idbook;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIsbn() {
		return this.isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}
	

}