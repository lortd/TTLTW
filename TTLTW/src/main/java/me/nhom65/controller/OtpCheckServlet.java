package me.nhom65.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nhom65.model.OTP;
import me.nhom65.model.User;
import me.nhom65.service.UserService;

@WebServlet("/otp")
public class OtpCheckServlet  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8580178537323339487L;
	private UserService userService;
	
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/otp.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = (String) request.getSession().getAttribute("email");
		String otp = request.getParameter("otp");
    
		if(otp == null || otp.isBlank()) {
			request.setAttribute("error", "Hãy nhập OTP vào");
			request.getRequestDispatcher("/otp.jsp").forward(request, response);
		}
		
		User user = userService.getUserByEmail(gmail);

		if(user == null) {
			request.setAttribute("error", "Không tìm thấy user, hãy đăng ký trước đã");
			request.getRequestDispatcher("/otp.jsp").forward(request, response);
			return;
		}
		OTP findotp = userService.getOtp(user.getUserName(), "REGISTER", otp);
		
		//Neu tim thay otp, kich hoat va dang nhap han luon
		if(findotp != null) {
			if(userService.activeOtp(user.getUsedId(), "REGISTER", otp)) {
				HttpSession session = request.getSession(true);
	            session.setAttribute("currentUser", user);
	            response.sendRedirect(request.getContextPath() + "/home");
	            return;
			} else {
				request.setAttribute("error", "Lỗi cập nhật otp");
				request.getRequestDispatcher("/otp.jsp").forward(request, response);
				return;
			}
			
		} 
		request.setAttribute("error", "Nhập sai otp, hãy nhập lại");
		request.getRequestDispatcher("/otp.jsp").forward(request, response);
		return;
	}
}
