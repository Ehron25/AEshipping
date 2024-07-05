package com.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.DAO.UsersDAO;
import com.crud.model.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO;

    public void init() {
        usersDAO = new UsersDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        User newUser = new User(username, password, "", firstName, middleName, lastName);
        try {
            usersDAO.insertUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("registration-success.jsp");
    }
}
