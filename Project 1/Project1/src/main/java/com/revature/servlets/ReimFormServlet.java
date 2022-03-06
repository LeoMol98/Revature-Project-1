package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ReimFormServlet extends HttpServlet {

        ReimbursementDAO reimDAO = new ReimbursementDAO();
        ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
    if(session != null) {
        String date = req.getParameter("date");
        String location = req.getParameter("location");
        String certification = req.getParameter("certificationtype");
        String amount = req.getParameter("amount");

        User author = (User) session.getAttribute("employee");
        Reimbursement reim = new Reimbursement(author, Integer.valueOf(amount), Status.PENDING, date, location, certification);

        reimDAO.insert(reim);
    }else{
        resp.sendRedirect("login.html");
    }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if(session != null) {
            User author = (User) session.getAttribute("employee");
            List<Reimbursement> r = reimDAO.getById(author.getId());
            String resonse = objectMapper.writeValueAsString(r);
           resp.getWriter().write(resonse);


        }else{
            resp.sendRedirect("login.html");
        }
    }
}
