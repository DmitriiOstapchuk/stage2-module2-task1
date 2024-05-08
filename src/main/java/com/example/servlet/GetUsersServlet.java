package com.example.servlet;

import com.example.Warehouse;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    private Warehouse warehouse = Warehouse.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("users", warehouse.getUsers());
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to retrieve users");
        }
    }
}
