package library_management_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class library_add_book_main {

	public void add_db(String name, String Author, int Price)
	{
	Book_details book = new Book_details();
	book.setBook_name(name);
	book.setBook_author(Author);
	book.setBook_price(Price);
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	session.save(book);
	session.getTransaction().commit();
	session.close();
    book= null;
	}
}
