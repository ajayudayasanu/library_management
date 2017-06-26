package library_management_Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class library_add_book_main {

	
	public void add_db(String name, String Author, int Price,String Book_edition, int pages,String language,Date date_of_publish,Boolean avaliblity,int isbn)
	{
	Book_details book = new Book_details();
	book.setBook_name(name);
	book.setBook_author(Author);
	book.setBook_price(Price);
	book.setBook_edition(Book_edition);
	book.setPages(pages);
	book.setLanguage(language);
	book.setDate_of_publish(date_of_publish);
	book.setAvailability(avaliblity);
	book.setISBN(isbn);
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	session.save(book);
	session.getTransaction().commit();
	session.close();
    book= null;
	}
}
