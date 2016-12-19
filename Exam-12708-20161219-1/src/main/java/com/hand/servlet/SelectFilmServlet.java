package com.hand.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.entity.Film;
import com.hand.service.SelectFilmService;


public class SelectFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectFilmService service=new SelectFilmService();      

    public SelectFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Film> itemList=service.select();
		HttpSession session=request.getSession();
		session.setAttribute("itemList",itemList);
		request.setAttribute("itemList", itemList);
		if (itemList != null) {
			System.out.println(itemList.get(0).getDescription());
			request.getRequestDispatcher("main.jsp").forward(request, response);    
		}else{
			request.setAttribute("errorMsg","film表没有数据");
			request.getRequestDispatcher("error.jsp").forward(request, response);    
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
