package library_management_system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library_management_Hibernate.Book_details;
@Controller
public class View_by_id {

	@RequestMapping("View_book/view_by_id")
	public ModelAndView search_book(HttpServletRequest request, HttpServletResponse response)
	{	
		Book_details book = new Book_details();
		int book_ID= Integer.parseInt(request.getParameter("book_ID"));
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		book= (Book_details) session.get(Book_details.class, book_ID);
		int book_id= book.getBook_ID();
		String book_name= book.getBook_name();
		String book_author= book.getBook_author();
		int price= book.getBook_price();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("view_by_ID_serch_result.jsp");
		mv.addObject("book_id",book_id);
		mv.addObject("book_name",book_name);
		mv.addObject("book_author", book_author);
		mv.addObject("book_price", price);	
		return mv;
	}
	
}
