package me.nhom65.controller;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nhom65.model.User;
import me.nhom65.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6259630436033547445L;
	private UserService userService;
	
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
    
		User user = userService.getUserByName(username);

		if(username == null || username.isBlank() || password == null || password.isBlank()) {
			request.setAttribute("error", "Không được phép để trống");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
    
    if (user != null) {
    	if(user.getPasswordHash().equals(password)) {
    		if(userService.isUnActiveOtp(username, "REGISTER")) {
    			HttpSession session = request.getSession(true);
                session.setAttribute("email", user.getEmail());
    			response.sendRedirect("otp");
            	return;
    		} else {
    			HttpSession session = request.getSession(true);
            	session.setAttribute("currentUser", user);
            	response.sendRedirect(request.getContextPath() + "/home");
            	return;
    		}
    	} 
    }
    request.setAttribute("error", "Sai username hoặc password");
    request.setAttribute("username", username);
    request.getRequestDispatcher("/login.jsp").forward(request, response);
    
	}
	

	
}
