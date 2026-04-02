package me.nhom65.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.nhom65.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
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
		request.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String gmail = request.getParameter("gmail");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        request.setAttribute("username", username);

        if(!validInput(username,password,confirmPassword,gmail,phone,address)) {
        	  request.setAttribute("error", "Đang bị thiếu thông tin");
        	  request.getRequestDispatcher("/register.jsp").forward(request, response);
        	  return;
        }
        if (userService.addUser(username,password,confirmPassword,gmail,phone,address)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Đăng ký thất bại -> forward lại + hiển thị lỗi
        request.setAttribute("error", "Lỗi đăng ký thất bại");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

	private boolean validInput(String username, String password, String confirmPassword, String gmail, String phone,
			String address) {
		if (username == null || password == null || confirmPassword == null || gmail == null || phone == null || address == null) {
			return false;
		}
		if(!password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}
	

	
}