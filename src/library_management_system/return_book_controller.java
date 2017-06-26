package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
public class return_book_controller {
	
	@RequestMapping("return_book/return_book")
	public ModelAndView issuebook(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		long no_of_days=0;
		long fine=0;
		//normal confirmation
		ModelAndView mv= new ModelAndView();
		mv.setViewName("return_book_confirmation.jsp");
		// book not_avalible
		ModelAndView mv_book_ID_not_avalible= new ModelAndView();
		mv_book_ID_not_avalible.setViewName("return_book_notassigned_to_user.jsp");
		// error in date
		ModelAndView return_book_error_in_date= new ModelAndView();
		return_book_error_in_date.setViewName("return_book_error_in_date.jsp");	
		// wrong book_id
		ModelAndView return_book_wrong_book_id= new ModelAndView();	
		return_book_wrong_book_id.setViewName("return_book_wrong_book_id.jsp");
		
		Book_details book = new Book_details();
		User_details user = new User_details();
		
		int User_ID= Integer.parseInt(request.getParameter("user_ID"));
		int Book_ID= Integer.parseInt(request.getParameter("book_ID"));
		
		String  Date_of_return_get=(request.getParameter("date_of_return")).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_of_return = sdf.parse(Date_of_return_get);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		
		user= (User_details) session.get(User_details.class, User_ID);
		String user_name= user.getUser_name();
		int book1_id= user.getBook1_ID();
		int book2_id= user.getBook2_ID();
		Date book1_issue= user.getBook1_issue();
		Date book2_issue= user.getBook2_issue();
		
		book= (Book_details) session.get(Book_details.class, Book_ID);
		String book_name= book.getBook_name();
		Boolean availability= book.getAvailability();
		
		if(availability == false)
		{
		
			if(Book_ID==book1_id)
			{
				//finding_no_of_days
				try
				{
				long diffrence= date_of_return.getTime()-book1_issue.getTime();
				 no_of_days= TimeUnit.DAYS.convert(diffrence, TimeUnit.MILLISECONDS);
				}
				catch(Exception e){
					 //error in calculating date sent to error page
				return	return_book_error_in_date;
					}
				
			    fine=fine_struture(no_of_days);  
							
				user.setBook1_ID(0);
				user.setBook1_issue(null);
				book.setAvailability(true);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				mv.addObject("User_ID", User_ID);	
				mv.addObject("user_name", user_name);				
				mv.addObject("book_name", book_name);
				mv.addObject("book_id", book1_id);
				mv.addObject("book_issue", book1_issue);
				mv.addObject("book_return", date_of_return);
				mv.addObject("no_of_days", no_of_days);
				mv.addObject("fine", fine);
				return mv;
			}
			else if(Book_ID==book2_id )
			{
				user.setBook2_ID(0);
				user.setBook2_issue(null);
				book.setAvailability(true);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				mv.addObject("User_ID", User_ID);	
				mv.addObject("user_name", user_name);
				mv.addObject("book_id", book2_id);
				mv.addObject("book_name", book_name);
				mv.addObject("book_issue", book2_issue);
				mv.addObject("book_return", date_of_return);
				mv.addObject("no_of_days", no_of_days);
				mv.addObject("fine", fine);
				return mv;
			}
			else
			{
				//wrong book_id
				return return_book_wrong_book_id;
				
			}
		}
		else{
			// book is not_avalible
			return mv_book_ID_not_avalible;
		}
		
		
		
	}
	public static long fine_struture(long no_of_days)
	{
		//fine_struture
		long fine=0;
		long fine_days;
		if(no_of_days<21)
		{
			fine=0;
		}
		else if(no_of_days>21 && no_of_days<28)
		{
		  fine_days= no_of_days-21;
		 fine= fine_days*2;
		}
		else if(no_of_days>28 && no_of_days<35)
		{
			fine_days= no_of_days-28;
			fine= 14+(fine_days*4);
		}
		else if(no_of_days>35 && no_of_days<42)
		{
			fine_days= no_of_days-35;
			fine= 42+(fine_days*6);
		}
		else if(no_of_days>42)
		{
			fine= 84+((no_of_days-42)*8);
		}
		return fine;
	}

}
