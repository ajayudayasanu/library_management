package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class issue_book_controller {
	@RequestMapping("issue_book/issue_book")
	public ModelAndView issuebook(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("issue_book_confirmation.jsp");
		ModelAndView mv_limit_excced= new ModelAndView();
		mv_limit_excced.setViewName("issue_book_limit.jsp");
		ModelAndView mv_book_not_avalible= new ModelAndView();
		mv_book_not_avalible.setViewName("book_not_avalible.jsp");
		Book_details book = new Book_details();
		User_details user = new User_details();
		
		int User_ID= Integer.parseInt(request.getParameter("user_ID"));
		int Book_ID= Integer.parseInt(request.getParameter("book_ID"));
		
		String  Date_of_issue_get=(request.getParameter("date_of_issue")).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_of_issue = sdf.parse(Date_of_issue_get);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		
		user= (User_details) session.get(User_details.class, User_ID);
		String user_name= user.getUser_name();
		int book1_id= user.getBook1_ID();
		int book2_id= user.getBook2_ID();
		
		book= (Book_details) session.get(Book_details.class, Book_ID);
		String book_name= book.getBook_name();
		Boolean availability= book.getAvailability();
		if(availability== true)
		{
			if(book1_id ==0)
			{
				user.setBook1_ID(Book_ID);
				user.setBook1_issue(date_of_issue);
				book.setAvailability(false);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				mv.addObject("user_id", User_ID);
				mv.addObject("book_id", Book_ID);
				mv.addObject("book_name", book_name);
				mv.addObject("username", user_name);
				mv.addObject("issue_date",Date_of_issue_get);
				
				return mv;
				
			}
			else if (book2_id ==0)
			{
				user.setBook2_ID(Book_ID);
				user.setBook2_issue(date_of_issue);
				book.setAvailability(false);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				mv.addObject("user_id", User_ID);
				mv.addObject("book_id", Book_ID);
				mv.addObject("book_name", book_name);
				mv.addObject("username", user_name);
			
				return mv;
			}
			else
			{
				Boolean limit= true;
				mv_limit_excced.addObject("book_limit_exceed", limit);
				return mv_limit_excced;
			}
			
		}
		else
		{
			Boolean book_not_avalible= true;
			mv_book_not_avalible.addObject("book_not_avalible", book_not_avalible);
			return mv_book_not_avalible;
		}
		
				
		
	}
	}


