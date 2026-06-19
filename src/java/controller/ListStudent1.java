/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author LENOVO
 */
public class ListStudent1 extends HttpServlet {

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
            out.println("<title>Servlet ListStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListStudent at " + request.getContextPath() + "</h1>");
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
    public void init() throws ServletException {
        // Khởi tạo list 1 lần khi servlet load
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "a", 2.5));
        list.add(new Student(2, "b", 3.5));
        list.add(new Student(3, "c", 4.5));
        list.add(new Student(4, "d", 5));
        getServletContext().setAttribute("list", list);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy list từ context để hiển thị
        request.setAttribute("list", getServletContext().getAttribute("list"));
        request.getRequestDispatcher("listStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String gpaStr = request.getParameter("gpa");

        int id = Integer.parseInt(idStr);
        double gpa = Double.parseDouble(gpaStr);

        if (id <= 0) {
            request.setAttribute("error", "Id phải > 0");
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }
        if (name.isEmpty()) {
            request.setAttribute("error", "Không được bỏ trống");
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }
        if (gpa < 0 || gpa > 10) {
            request.setAttribute("error", "0 <= gpa <= 10");
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }

        // Lấy list hiện tại từ context và thêm vào
        ArrayList<Student> list = (ArrayList<Student>) getServletContext().getAttribute("list");
        list.add(new Student(id, name, gpa));

        request.setAttribute("list", list);
        request.getRequestDispatcher("listStudent.jsp").forward(request, response);
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
