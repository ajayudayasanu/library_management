package library_management_Hibernate;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;




@Entity(name="Book_details")
public class Book_details {
	@Id
	
	@GeneratedValue
	int Book_ID;
	String Book_name;
	String Book_author;
	String Book_edition;
	int Book_price;
	int pages;
	int ISBN;
	String language;
	Date date_of_publish;
	Boolean  availability;
	
	

	public int getBook_ID() {
		return Book_ID;
	}
	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}
	public String getBook_name() {
		return Book_name;
	}
	public void setBook_name(String book_name) {
		Book_name = book_name;
	}
	public String getBook_author() {
		return Book_author;
	}
	public void setBook_author(String book_author) {
		Book_author = book_author;
	}
	public int getBook_price() {
		return Book_price;
	}
	public void setBook_price(int book_price) {
		Book_price = book_price;
	}


	public String getBook_edition() {
		return Book_edition;
	}
	public void setBook_edition(String book_edition) {
		Book_edition = book_edition;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getDate_of_publish() {
		return date_of_publish;
	}
	public void setDate_of_publish(Date date_of_publish) {
		this.date_of_publish = date_of_publish;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
}
