package com.revature.models;

import java.util.Scanner;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {


    String name;
    String lastName;

    public User() {
        super();
    }


    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */


//    public User (String Username, String password, String employeeName, String employeeLastName, Role role){
////        super(Username, password, role);


//public User(String employeeName, String employeeLastName, String username, String password, Role role){
//    this.employeeName = employeeName;
//    this.employeeLastName = employeeLastName;
//    this.Username= username;
//    this.password = password;
//    this.getRole();
//}
    public User(int id, String username, String password, Role role) {
        super(id, username, password, role);
    }

    public User(int id, String username, String password) {
        super(id, username, password);

    }

    public User(String username, String password, Role role){super(username, password, role);}


    public User(String name, String lastName) {
       this.name = name;
       this.lastName = lastName;
    }


}
//    public User(int id, String username, String password, Role role, String employeeName, String employeeLastName) {
//        super(id, username, password, role);
//        this.employeeName = employeeName;
//        this.employeeLastName = employeeLastName;
//    }


//    public User(int id) {
//        this.employeeName = first_name;
//        super(id, username, password,role);
//
//
//    }












