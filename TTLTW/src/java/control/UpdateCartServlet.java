package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAO;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/update-cart")
public class UpdateCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cartItemId = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		DAO dao = new DAO();
		dao.updateCartItemQuantity(cartItemId, action);

		response.getWriter().write("");
	}
}