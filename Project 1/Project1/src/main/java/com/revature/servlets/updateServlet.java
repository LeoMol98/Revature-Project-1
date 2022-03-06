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

public class updateServlet extends HttpServlet {


ObjectMapper objectMapper = new ObjectMapper();
ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
//        String approved = req.getParameter("Approved Requests");


            User resolver = (User) session.getAttribute("employee");
//            User author = objectMapper.readValue(req.getReader(), User.class);
//        System.out.println(author);
            Reimbursement r = objectMapper.readValue(req.getReader(), Reimbursement.class);
        System.out.println(r);
            r.setResolver(resolver);
            System.out.println(r);
            reimbursementDAO.update(r.getId(), r.getStatus(), resolver.getId());
//if(r.getStatus() == APPROVED){
reimbursementDAO.updateAllowance(r.getId(), r.getAmount(), r.getCertificationtype());
    System.out.println(r.getId());
    System.out.println(r.getAmount());
    System.out.println(r.getCertificationtype());
    }
}
