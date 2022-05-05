package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form

        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean emailDoesntExist = false;
        boolean fieldsNotNull = false;
        boolean fieldsNotEmpty = false;

        if (username!= null && email != null && password != null){
            fieldsNotNull = true;
        }

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            fieldsNotEmpty = true;
        }

//        if(username.equals(******))


        // TODO: create a new user based off of the submitted information

        if (fieldsNotEmpty && fieldsNotEmpty){

            User user = new User(username, email, password);

            DaoFactory.getUsersDao().insert(user);

        }

        // TODO: if a user was successfully created, send them to their profile

        response.sendRedirect("/profile");

    }
}
