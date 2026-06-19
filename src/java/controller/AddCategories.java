package controller;

import dal.CategoriesDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;

public class AddCategories extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriesDAO cDAO = new CategoriesDAO();
        ArrayList<String> error = new ArrayList<>();

        int id = 0;
        String name = request.getParameter("name");
        try {
            id = Integer.parseInt(request.getParameter("id"));
            if (id <= 0) {
                throw new Exception("negative id");
            }
            if (cDAO.getCategoriesById(id) != null) {
                error.add("Categories with id = " + id + " already exists.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            error.add("ID must be a positive integer number.");
        }
        if (name == null || name.isBlank()) {
            error.add("Name must not be blank.");
        } else if (cDAO.getCategoriesByName(name.trim()) != null) {
            error.add("Categories with name = '" + name + "' already exists.");
        }
        if (error.size() > 0) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("addCategories.jsp").forward(request, response);
        } else {
            String e = cDAO.addCategories(id, name.trim());

            if (e != null) {
                error.add(e);
                request.setAttribute("error", error);
                request.getRequestDispatcher("addCategories.jsp").forward(request, response);
            } else {
                response.sendRedirect("listCategories");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");

        String error = null;
        int id = 0;

        try {
            id = Integer.parseInt(idParam.trim());
            if (id <= 0) {
                error = "ID must be greater than 0!";
            }
        } catch (NumberFormatException | NullPointerException e) {
            error = "ID must be a valid number!";
        }

        if (error == null) {
            if (name == null || name.trim().isEmpty()) {
                error = "Name must not be blank!";
            }
        }

        CategoriesDAO dao = new CategoriesDAO();

        if (error == null) {
            if (dao.isIdExist(id)) {
                error = "ID already exists!";
            }
        }

        if (error == null) {
            if (dao.isNameExist(name.trim())) {
                error = "Name already exists!";
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("id", idParam);
            request.setAttribute("name", name);
            request.getRequestDispatcher("addCategories.jsp").forward(request, response);
            return;
        }

        String result = dao.addCategories(id, name.trim());

        if (result == null) {
            response.sendRedirect("listCategories");
        } else {
            request.setAttribute("error", result);
            request.setAttribute("id", idParam);
            request.setAttribute("name", name);
            request.getRequestDispatcher("addCategories.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Add Categories Servlet";
    }
}
