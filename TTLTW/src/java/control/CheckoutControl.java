package control;

import dao.DAO;
import entity.CartItemDTO;
import entity.Category;
import entity.Product;
import entity.User;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CheckoutControl", urlPatterns = {"/checkout"})
public class CheckoutControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
DAO dao = new DAO();
        
        // 1. Lấy tất cả tham số từ Form gửi lên
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            // Tìm các tham số có tên bắt đầu bằng qty_ (ví dụ: qty_5, qty_6)
            if (name.startsWith("qty_")) {
                int cartItemId = Integer.parseInt(name.substring(4)); // lấy ID (số 5, số 6)
                int quantity = Integer.parseInt(request.getParameter(name));
                
                // 2. Cập nhật số lượng mới nhất vào DB
                dao.updateQuantityDirectly(cartItemId, quantity);
            }
        }

        // 3. Lấy lại danh sách đã cập nhật để gửi sang Checkout.jsp
        User acc = (User) request.getSession().getAttribute("acc");
        List<CartItemDTO> list = dao.getCartItemsByUserId(acc.getUserId());
        
        request.setAttribute("checkoutList", list);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
