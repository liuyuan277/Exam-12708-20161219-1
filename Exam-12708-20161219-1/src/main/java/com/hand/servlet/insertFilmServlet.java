package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.entity.Film;
import com.hand.service.InsertFilmService;
public class insertFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InsertFilmService service=new InsertFilmService();
    public insertFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String language=request.getParameter("language");
		Film film=new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(Integer.parseInt(language));
		System.out.println(title+" "+description+" "+Integer.parseInt(language));
		service.insert(film);
		
		
        HttpSession session=request.getSession();
        int pageNo=(Integer)session.getAttribute("curentPageNo");
        System.out.println("curentPageNo" +pageNo );

//		if(b){
			request.getRequestDispatcher("selectFilmByPageServlet?pageNo="+pageNo).forward(request, response);    
//		}else{
//			request.setAttribute("errorMsg","数据数据失败");
//			request.getRequestDispatcher("error.jsp").forward(request, response);    
//			
//		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
