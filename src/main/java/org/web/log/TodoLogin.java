package org.web.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.todo1.User;
import org.web.todo1.UserService;

@WebServlet("/TodoLogin")
public class TodoLogin extends HttpServlet {
	
	UserService service = new UserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("password");
		System.out.println("TodoLogin: " + request.getParameter(""));
		
		User user = new User(id, passwd);
		System.out.println(user.getName());
		
		if (service.isValidUser(user)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("name", user.getName());
			
			request.getRequestDispatcher("/index2.jsp").forward(request, response);
			
		} else {
			request.setAttribute("error","Wrong password");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
