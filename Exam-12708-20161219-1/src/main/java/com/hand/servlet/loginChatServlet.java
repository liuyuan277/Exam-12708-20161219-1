package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.entity.Customer;
import com.hand.service.CheckUserService;


public class loginChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku = new CheckUserService();   

    public loginChatServlet() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String userName = req.getParameter("username");
       
		System.out.println("用户名 ==》 " + userName);

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		RequestDispatcher rd = null;
		String forward = null;
		if (userName == null) {
			req.setAttribute("msg", "用户名不可为空");
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		} else {
			Customer user = new Customer();
			user.setFirst_name(userName);
			boolean bool = cku.check(user);

			if (bool) {
				session.setAttribute("OnLineUser", userName);
				forward = "/main.jsp";
			} else {
				req.setAttribute("msg", "用户名错误");
				forward = "/error.jsp";
			}

			System.out.println(session.getAttribute("OnLineUser")+">>>>");
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
