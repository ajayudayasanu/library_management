package library_management_Hibernate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="user_details")
public class User_details {
	@Id
	@GeneratedValue
	int User_ID;
	String User_name;
	String Address;
	int Book1_ID;
	int Book2_ID;
	Date Book1_issue;
	Date  Book1_return;
	Date Book2_issue;
	Date  Book2_return;
	Boolean active;
	
	
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getBook1_ID() {
		return Book1_ID;
	}
	public void setBook1_ID(int book1_ID) {
		Book1_ID = book1_ID;
	}
	public int getBook2_ID() {
		return Book2_ID;
	}
	public void setBook2_ID(int book2_ID) {
		Book2_ID = book2_ID;
	}
	public Date getBook1_issue() {
		return Book1_issue;
	}
	public void setBook1_issue(Date book1_issue) {
		Book1_issue = book1_issue;
	}
	public Date getBook1_return() {
		return Book1_return;
	}
	public void setBook1_return(Date book1_return) {
		Book1_return = book1_return;
	}
	public Date getBook2_issue() {
		return Book2_issue;
	}
	public void setBook2_issue(Date book2_issue) {
		Book2_issue = book2_issue;
	}
	public Date getBook2_return() {
		return Book2_return;
	}
	public void setBook2_return(Date book2_return) {
		Book2_return = book2_return;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	

}
