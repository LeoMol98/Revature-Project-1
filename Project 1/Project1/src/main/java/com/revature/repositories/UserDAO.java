package com.revature.repositories;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    ConnectionFactory cu = ConnectionFactory.getInstance();

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getResolverByUsername(String username) {
        String sql = "select * from managerstable where username = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.FINANCE_MANAGER);
                return Optional.of(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.empty();
    }

    public User getEmployeeByUsername(String username) {
        String sql = "select * from employeestable where username = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.EMPLOYEE);
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     * <p>
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
public List<User> getAll(){
    List<User> users = new ArrayList<>();

    String sql = "select * from employeestable";
    try(Connection cnt = cu.getConnection()){
        PreparedStatement ps = cnt.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User a =  new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    Role.EMPLOYEE);
             users.add(a);
        }
        return users;
    }catch(SQLException e){
        e.printStackTrace();

    }

    return null;
}
    public User create(User userToBeRegistered) {

        switch (userToBeRegistered.getRole()) {
            case EMPLOYEE:
                String employee = "update employeestable set (username, password) = (?, ?)";
                try (Connection conn = cu.getConnection()) {
                    PreparedStatement ps = conn.prepareStatement(employee);
                    ps.setString(1, userToBeRegistered.getUsername());
                    ps.setString(2, userToBeRegistered.getPassword());

                    ResultSet rs = ps.executeQuery();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;

            case FINANCE_MANAGER:
            String financial = "update employeestable set (username, password) = (?, ?)";
            try (Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(financial);
                ps.setString(1, userToBeRegistered.getUsername());
                ps.setString(2, userToBeRegistered.getPassword());

                ResultSet rs = ps.executeQuery();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

//Select User
    public User getbyID(int UserID){
    String sql = "select * from employeestable where id = ?";

    try(Connection conn = cu.getConnection()){
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, UserID);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            User u = new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    Role.EMPLOYEE
            );

            return u;
        }
    }catch(SQLException e){
        e.printStackTrace();
        return null;}

    return null;
    }

    public User getResolverByID(int UserID){
        String sql = "select * from managerstable where id = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, UserID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.FINANCE_MANAGER
                );

                return u;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;}

        return null;
    }

//    public Optional<User> getAuthByUsername(String username){
//        String sql = "select * from employeestable where username = ?";
//
//        try(Connection conn = cu.getConnection()){
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()){
//                User u = new User(
//                        rs.getInt("id"),
//                        rs.getString("username"),
//                        rs.getString("password"),
//                        Role.EMPLOYEE
//                );
//
//                return Optional.of(u);
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//            return Optional.empty();}
//
//        return Optional.empty();
//    }

    public User getbyIDUser(int UserID){
        String sql = "select * from employeestable where id = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, UserID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.EMPLOYEE
                );

                return u;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;}

        return null;
    }


    public User getbyIDRes(int UserID){
        String sql = "select * from managerstable where id = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, UserID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.FINANCE_MANAGER
                );

                return u;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;}

        return null;
    }

    public void updateEmployee(User updatedEmployee){
        String sql = "update employeestable set (username, password) = (?, ?) where id = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, updatedEmployee.getUsername());
            ps.setString(2,updatedEmployee.getPassword());
            ps.setInt(3, updatedEmployee.getId());

            ResultSet rs = ps.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
            }
    }

    public void updateManager(User updatedManager){
        String sql = "update employeestable set (username, password) = ('?', '?') where id = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, updatedManager.getUsername());
            ps.setString(2,updatedManager.getPassword());
            ps.setInt(3, updatedManager.getId());



        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public User add(User userToBeRegistered) {

        String sql = "update employeestable set (username, password) = (?, ?) where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userToBeRegistered.getUsername());
            ps.setString(2, userToBeRegistered.getPassword());
            ps.setInt(3, userToBeRegistered.getId());

            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
