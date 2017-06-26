package library_management_system;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library_management_Hibernate.Book_details;
import library_management_Hibernate.User_details;
@Controller
public class view_user_controller {
	@RequestMapping("view_user/view_user")
	public ModelAndView search_book(HttpServletRequest request, HttpServletResponse response)
	{	
		String book1_name=null;
		String book2_name=null;
		User_details user= new User_details();
		Book_details book = new Book_details();
		int user_ID= Integer.parseInt(request.getParameter("user_ID"));
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		
		user= (User_details) session.get(User_details.class, user_ID);
		String user_name= user.getUser_name();
		int book1_id= user.getBook1_ID();
		int book2_id= user.getBook2_ID();
		Date book1_issue= user.getBook1_issue();
		Date book2_issue= user.getBook2_issue();
		
		if (book1_id !=0)
		{
		book= (Book_details) session.get(Book_details.class, book1_id);
		book1_name= book.getBook_name();
		}
		else if(book2_id !=0)
		{
			book= (Book_details) session.get(Book_details.class, book2_id);
			 book2_name= book.getBook_name();
		}
		else
		{
			
		}
		ModelAndView mv= new ModelAndView();
		mv.setViewName("view_user_result.jsp");
		
		mv.addObject("user_name",user_name);
		mv.addObject("book1_id",book1_id);
		mv.addObject("book1_name",book1_name);
		mv.addObject("book1_issue",book1_issue);
		
		mv.addObject("book2_id",book2_id);
		mv.addObject("book2_name",book2_name);
		mv.addObject("book2_issue",book2_issue);
		return mv;
		
	}
}
