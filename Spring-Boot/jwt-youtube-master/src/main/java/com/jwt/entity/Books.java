package com.jwt.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String bookName;
	private String bookImage;
	private String bookRate;
	private String bookAvailable;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_BOOK", joinColumns = { @JoinColumn(name = "USER_NAME") }, inverseJoinColumns = {
			@JoinColumn(name = "Book_ID") })
	private Set<User> user;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public String getBookRate() {
		return bookRate;
	}
	public void setBookRate(String bookRate) {
		this.bookRate = bookRate;
	}
	public String getBookAvailable() {
		return bookAvailable;
	}
	public void setBookAvailable(String bookAvailable) {
		this.bookAvailable = bookAvailable;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
