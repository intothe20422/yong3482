package org.web.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.todo1.User;

@WebServlet("/TodoLogout")
public class TodoLogout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user != null) {
			session.invalidate();
			
			response.sendRedirect("/index.jsp");
		} else {
			request.setAttribute("", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
