package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.entity.Film;
import com.hand.service.UpdateFilmService;


public class updateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateFilmService service=new UpdateFilmService();

    public updateFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     String film_id=request.getParameter("film_id");
	         String title=request.getParameter("title");
	         String description=request.getParameter("description");
	         String language=request.getParameter("language");
	         
	         HttpSession session=request.getSession();
	         int pageNo=(Integer)session.getAttribute("curentPageNo");
	         System.out.println("curentPageNo" +pageNo );
	         Film film=new Film();
	         film.setTitle(title);
	         film.setFilm_id(Integer.parseInt(film_id));
	         film.setDescription(description);
	         film.setLanguage_id(Integer.parseInt(language));

	         service.update(film);
	         request.getRequestDispatcher("selectFilmByPageServlet?pageNo="+pageNo).forward(request, response);    
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
