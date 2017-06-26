package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library_management_Hibernate.library_add_book_main;
@Controller
public class Library_add_book_controller {

	@RequestMapping("add_new_book/add_book")
	public ModelAndView add_book(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{	
		String name= (request.getParameter("Name")).toString();
		String  author=(request.getParameter("Author")).toString();
		int Price= Integer.parseInt(request.getParameter("price"));			
		String  Book_edition=(request.getParameter("Book_edition")).toString();
		int pages = Integer.parseInt(request.getParameter("pages"));
		int ISBN = Integer.parseInt(request.getParameter("ISBN"));
		String  language=(request.getParameter("language")).toString();
		
		String  Date_of_publish_get=(request.getParameter("date_of_publish")).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Date_of_publish = sdf.parse(Date_of_publish_get);
		
		Boolean avalibility= true;
		
		library_add_book_main addbook= new library_add_book_main();
		addbook.add_db(name, author, Price,Book_edition,pages,language,Date_of_publish,avalibility,ISBN);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Addbookconfirmation.jsp");
		mv.addObject("book_name",name);
		mv.addObject("book_author", author);
		mv.addObject("book_price", Price);
		mv.addObject("Book_edition", Book_edition);
		mv.addObject("pages", pages);
		mv.addObject("language", language);
		mv.addObject("Date_of_publish", Date_of_publish);		
		return mv;
	
}
	
	

}
