package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.dao.FilmDao;
import com.hand.util.PageUtil;

public class selectFilmByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public selectFilmByPageServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=1;
		if(request.getParameter("pageNo")!=null){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));			
		}else{
			
		}
		HttpSession session=request.getSession();
		FilmDao usi=new FilmDao();
		PageUtil page = usi.getPage(pageNo, 10);
        page.setPageNo(pageNo);
        session.setAttribute("page", page);
        request.getRequestDispatcher("showItemList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
