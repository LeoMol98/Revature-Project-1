package com.revature.servlets;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    AuthService authService = new AuthService();
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get thr parameters of username and password fron the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = authService.login(username, password);
//        User r = authService.loginM(username, password);
        if (u != null) {
            if(u.getRole() == Role.EMPLOYEE) {
                HttpSession session = request.getSession();
                User employee = userDAO.getEmployeeByUsername(username);
//            response.getWriter().write("Succesflly logged in");
                session.setAttribute("employee", employee);
                response.sendRedirect("employee.html");
            }else{
                HttpSession session = request.getSession();
                User employee = userDAO.getEmployeeByUsername(username);
//            response.getWriter().write("Succesflly logged in");
                session.setAttribute("employee", employee);
                response.sendRedirect("managers.html");
            }
        } else {
            response.sendRedirect("register.html");

        }
    }
}

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("login.html").forward(request, response);
//
//    }
//        }else if (r != null){
////            u = authService.loginM(username, password);
//            HttpSession session = request.getSession();
//            Optional<User> manager = userDAO.getResolverByUsername(username);
//            session.setAttribute("manager", manager);
//            response.sendRedirect("managers.html");

