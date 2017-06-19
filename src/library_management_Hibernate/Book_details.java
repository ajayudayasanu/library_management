package library_management_Hibernate;


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
	int Book_price;
	

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

}
