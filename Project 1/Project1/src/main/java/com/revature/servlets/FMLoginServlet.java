//package com.revature.servlets;
//
//import com.revature.models.User;
//import com.revature.repositories.UserDAO;
//import com.revature.services.AuthService;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Optional;
//
//public class FMLoginServlet extends HttpServlet {
//    AuthService authService = new AuthService();
//    UserDAO userDAO = new UserDAO();
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //Get thr parameters of username and password fron the request
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User u = authService.loginM(username, password);
//        if( u != null){
//            HttpSession session = request.getSession();
//            Optional<User> user = userDAO.getResolverByUsername(username);
//            session.setAttribute("user",user);
//            response.sendRedirect("managers.html");
//        }else{
//            response.sendError(401);
//        }
//
//
//
//    }
//
//}
