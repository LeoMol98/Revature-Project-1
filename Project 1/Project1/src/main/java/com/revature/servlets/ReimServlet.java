package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.repositories.ReimbursementDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReimServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
List<Reimbursement> reim = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pending = req.getParameter("Pending Requests");
//        String approved = req.getParameter("Approved Requests");
//        String denied = req.getParameter("Denied Requests");

//      if(pending != null) {
          reim = reimbursementDAO.getAll();
          String responseBodyP = objectMapper.writeValueAsString(reim);
          resp.getWriter().write(responseBodyP);
//          return;
//      }else if (approved != null){
//          reim = reimbursementDAO.getByStatus(Status.APPROVED);
//          String responseBodyA = objectMapper.writeValueAsString(reim);
//          resp.getWriter().write(responseBodyA);
//          return;
//      }else if(denied != null)
//          reim = reimbursementDAO.getByStatus(Status.DENIED);
//        String responseBodyD = objectMapper.writeValueAsString(reim);
//        resp.getWriter().write(responseBodyD);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Reimbursement r = new Reimbursement();
       r = objectMapper.readValue(req.getReader(), Reimbursement.class);
        System.out.println(r);
    }
}
