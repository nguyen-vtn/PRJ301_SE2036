package controller;

import dal.CategoriesDAO; // Nhớ import DAO
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyendz
 */
// Sửa urlPatterns thành chữ 'd' thường để khớp với window.location bên file JSP
@WebServlet(name = "DeleteCategories", urlPatterns = {"/deleteCategories"})
public class DeleteCategories extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteCategories</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCategories at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đưa logic xóa vào doGet vì link window.location gọi GET request
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CategoriesDAO cDao = new CategoriesDAO();

            // Gọi hàm xóa từ DAO
            String error = cDao.deleteCategories(id);

            if (error != null) {
                // Nếu có lỗi (ví dụ dính khóa ngoại), báo lỗi
                request.setAttribute("error", error);
                request.getRequestDispatcher("listCategories").forward(request, response); // Sửa dấu chấm thành phẩy
            } else {
                // Xóa thành công thì load lại trang danh sách
                response.sendRedirect("listCategories");
            }
        } catch (Exception e) {
            // Bắt lỗi nếu ID không phải là số hoặc không lấy được
            response.sendRedirect("listCategories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
