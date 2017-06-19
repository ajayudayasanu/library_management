package library_management_system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library_management_Hibernate.library_add_book_main;
@Controller
public class Library_add_book_controller {

	@RequestMapping("add_new_book/add_book")
	public ModelAndView add_book(HttpServletRequest request, HttpServletResponse response)
	{	
		String name= (request.getParameter("Name")).toString();
		String  author=(request.getParameter("Author")).toString();
		int Price= Integer.parseInt(request.getParameter("price"));	
		library_add_book_main addbook= new library_add_book_main();
		addbook.add_db(name, author, Price);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Addbookconfirmation.jsp");
		mv.addObject("book_name",name);
		mv.addObject("book_author", author);
		mv.addObject("book_price", Price);
		return mv;
	
}
	
	

}
