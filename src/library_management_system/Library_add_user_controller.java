package library_management_system;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library_management_Hibernate.Add_user_main;
@Controller
public class Library_add_user_controller {
	@RequestMapping("Add_user/add_user")
	public ModelAndView add_user(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		String user_name= (request.getParameter("Name")).toString();
		String  Address=(request.getParameter("Address")).toString();
		int Book1_ID=0;
		int Book2_ID=0;
		Date Book1_issue= null;
		Date Book2_issue= null;
		Date Book1_return= null;
		Date Book2_return= null;
		
		Add_user_main add_user= new Add_user_main();
		add_user.add_user_db(user_name, Address, Book1_ID, Book1_issue, Book1_return, Book2_ID, Book2_issue, Book2_return);
			
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Add_user_confirmation.jsp");
		mv.addObject("user_name",user_name);
		mv.addObject("Address",Address);
		return mv;
		
	}
	}

