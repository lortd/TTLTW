package me.nhom65.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nhom65.model.User;
import me.nhom65.service.MailService;
import me.nhom65.service.UserService;
import me.nhom65.util.UserValidcator;
import me.nhom65.util.UserValidcator.ResultValidcator;

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
        User check = userService.getUserByName(username);
        ResultValidcator rs = UserValidcator.checkRegister(check, username, password, confirmPassword, gmail, phone, address);
        
        if(!rs.isSuccess()) {
        	request.setAttribute("error", rs.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if (userService.addUser(username,password,confirmPassword,gmail,phone,address)) {
        	userService.createOtp(username,"REGISTER", LocalDateTime.now().plusMinutes(15));
        	HttpSession session = request.getSession(true);
            session.setAttribute("email", gmail);
			response.sendRedirect("otp");
        	return;
        } 
        request.setAttribute("error", "Lỗi đăng ký thất bại");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }



	
}