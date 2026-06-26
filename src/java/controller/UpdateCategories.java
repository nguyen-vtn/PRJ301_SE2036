/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Categories;

/**
 *
 * @author nguyendz
 */
@WebServlet(name = "UpdateCategories", urlPatterns = {"/UpdateCategories"})
public class UpdateCategories extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCategories</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCategories at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            CategoriesDAO cDao = new CategoriesDAO();
            Categories c = cDao.getCategoriesById(id);

            if (c == null) {
                response.sendRedirect("listCategories");
            } else {
                request.setAttribute("categories", c);
                request.getRequestDispatcher("updateCategories.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect("listCategories");
        }
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
        CategoriesDAO cDao = new CategoriesDAO();
        ArrayList<String> error = new ArrayList<>();
        int id = 0;

        try {
            id = Integer.parseInt(request.getParameter("id"));
            if (cDao.getCategoriesById(id) == null) {
                response.sendRedirect("listCategories");
                return;
            }
        } catch (Exception e) {
            response.sendRedirect("listCategories");
            return;
        }

        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            error.add("Name must not be blank");
        } else {
            Categories c = cDao.getCategoriesByName(name);
            if (c != null && c.getId() != id) {
                error.add("Categories with name = '" + name + "' already exists.");
            }
        }

        // Xử lý điều kiện dựa trên mảng error
        if (error.size() > 0) {
            request.setAttribute("error", error);
            request.setAttribute("categories", new Categories(id, name));
            request.getRequestDispatcher("updateCategories.jsp").forward(request, response);
        } else {
            try {
                // Gọi hàm update kiểu void giống hệt như cô bạn viết
                cDao.updateCategories(new Categories(id, name.trim()));

                // Thành công thì quay về trang danh sách
                response.sendRedirect("listCategories");
            } catch (Exception ex) {
                // Nếu DB có lỗi gì (ví dụ: lỗi kết nối, sai tên cột...), nó sẽ nhảy vào đây
                error.add("Dữ liệu không hợp lệ hoặc lỗi hệ thống: " + ex.getMessage());
                request.setAttribute("error", error);
                request.setAttribute("categories", new Categories(id, name));
                request.getRequestDispatcher("updateCategories.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
