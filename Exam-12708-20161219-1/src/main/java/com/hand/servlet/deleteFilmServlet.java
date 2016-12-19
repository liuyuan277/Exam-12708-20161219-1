package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.entity.Film;
import com.hand.service.DeleteFilmService;

public class deleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteFilmService service=new DeleteFilmService();
    public deleteFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String film_id=request.getParameter("film_id");
           Film film=new Film();
           film.setFilm_id(Integer.parseInt(film_id));
           service.delete(film);
           
	         HttpSession session=request.getSession();
	         int pageNo=(Integer)session.getAttribute("curentPageNo");
	         System.out.println("curentPageNo" +pageNo );
	         
           request.getRequestDispatcher("selectFilmByPageServlet?pageNo="+pageNo).forward(request, response);   
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
