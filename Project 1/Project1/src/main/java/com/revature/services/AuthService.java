package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The AuthService should handle login and registration for the ERS application.
 *
 * {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Retrieve Currently Logged-in User</li>
 *     <li>Change Password</li>
 *     <li>Logout</li>
 * </ul>
 */
public class AuthService {
ConnectionFactory cu = ConnectionFactory.getInstance();
    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
    UserDAO userDAO = new UserDAO();

    public List<User> getAll(){
        return userDAO.getAll();
    }

    public User login(String username, String password) {
        String sql = "select * from employeestable where username = ? and password = ?";

        try(Connection cnt = cu.getConnection()) {
            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User a = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                       Role.valueOf(rs.getString("role")));
                return a;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    return null;}

    public User loginM(String username, String password) {
        String sql = "select * from managerstable where username = ? and password = ?";

        try(Connection cnt = cu.getConnection()) {
            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User a = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.FINANCE_MANAGER);
                return a;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

        return null;}

    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
    public User register(User userToBeRegistered) {
        return null;
    }

    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public Optional<User> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }
}


//                        rs.getString("employee_name"),
//                        rs.getString("employee_lastname"),
//                        rs.getString("email"),
//                        rs.getInt("phone_number"),
//                        rs.getString("address")
