package com.revature.servlets;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = userDAO.getbyIDUser(id);
        User r = userDAO.getResolverByID(id);
//        resp.getWriter().write(String.valueOf(u));
//        resp.getWriter().write(String.valueOf(r));
        if(u != null){
         User updatedEmployee = new User(id, username, password);
        userDAO.add(updatedEmployee);
//            resp.getWriter().write(String.valueOf(updatedEmployee));
        }else if(r != null){
            User updatedManager = new User(id, username, password);
            userDAO.create(updatedManager);
        }else{
            resp.getWriter().write("Please Contact HR");
        }
    }
}
