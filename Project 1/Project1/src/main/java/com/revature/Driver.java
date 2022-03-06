package com.revature;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.services.UserService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.List;
import java.util.Scanner;

public class Driver {

    private static UserDAO userDAO = new UserDAO();
    public static void main(String[] args) {
//        List<User> users = userDAO.getAll();
//        System.out.println(users);

//        System.out.println("Hello, Please provide your Username and Password:");
        Scanner sc = new Scanner(System.in);
        ReimbursementDAO RD = new ReimbursementDAO();
        UserDAO userDAO = new UserDAO();
        AuthService login = new AuthService();
//        User u = new User(sc.next(), sc.next(), Role.EMPLOYEE);
//        System.out.println(userDAO.create(u));
        User m = new User();
        double amount = 100;
        double newDouble = amount * .65;
        System.out.println(newDouble);
//        System.out.println(u.login(sc.next(), sc.next()));
//        Reimbursement rim = new Reimbursement(userDAO.getbyIDUser(sc.nextInt()), userDAO.getbyIDRes(sc.nextInt()), sc.nextDouble(), Status.PENDING);
//        System.out.println(RD.update(rim));

//        System.out.println(userDAO.getbyID(sc.nextInt()));
//        public class Example {
//            String s1 = "hello";
//            String s2 = " world";
////s1.concat(s2);
//
//System.out.println(s1);
//            String s3 = s1.concat(s2);
//System.out.println(s3);
//        }
//
//
//
//            }
//    public class Example {
//        String s1 = "hello";
//        String s2 = " world";
//s1.concat(s2);
//
//System.out.println(s1);
//        String s3 = s1.concat(s2);
//System.out.println(s3);
//    }
//}
    }}