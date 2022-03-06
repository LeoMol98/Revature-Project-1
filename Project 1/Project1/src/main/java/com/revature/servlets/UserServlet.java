//package com.revature.servlets;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.models.User;
//import com.revature.services.AuthService;
//import com.revature.services.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class UserServlet extends HttpServlet {
//
//    AuthService authService = new AuthService();
//    UserService userService = new UserService();
//    //We're basically building an API
//    //We want to create RESTful endpoints
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//          StringBuffer urlString = request.getRequestURL();
//          StringBuilder uriString = new StringBuilder(request.getRequestURI());//->/Project1/users
//        System.out.println(uriString);
//        //
//        uriString.replace(0, request.getContextPath().length() +1, ""); //->/authors
//
//        int userId = 0;
//        if(uriString.indexOf("/") != -1){
//            userId = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "").toString());
//        }
//
//        if(userId == 0){
//            List<User> users = authService.getAll();
//
//            String responseBody = objectMapper.writeValueAsString(users);
//
//            response.getWriter().write(responseBody);
//
//        }else{
//            System.out.println();
//            User a = userService.getByIdUser(userId);
//            response.getWriter().write(objectMapper.writeValueAsString(a));
//        }
//
//
//
////            response.getWriter().write(objectMapper.writeValueAsString(authService.getAll()));
//    }
//}
