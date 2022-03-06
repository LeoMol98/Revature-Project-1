package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {
static ConnectionFactory cu = ConnectionFactory.getInstance();
    User u = new User();
    static UserDAO re = new UserDAO();

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public List<Reimbursement> getById(int id) {
        List<Reimbursement> reim = new ArrayList<>();
        String sql = "select * from reimbursement where author = ?";

        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Reimbursement r = new Reimbursement(
                        rs.getInt("reim_id"),
                        re.getbyIDUser(rs.getInt("author")),
                        re.getbyIDRes(rs.getInt("resolver")),
                        rs.getDouble("amount"),
                        Status.valueOf(rs.getString("status")),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getString("certificationtype")
                );

                 reim.add(r);

            }
            return reim;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
//    public List<Reimbursement> getByStatus(Status status) {
//
//        List<Reimbursement> reim = new ArrayList<>();
//        switch (status) {
//            case PENDING:
//                String pending = "select * from reimbursement where status = ?";
//                try (Connection cnt = cu.getConnection()) {
//                    PreparedStatement ps = cnt.prepareStatement(pending);
//                    ps.setString(1, String.valueOf(Status.PENDING));
//                    ResultSet rs = ps.executeQuery();
//
//                    while (rs.next()) {
//                        Reimbursement r = new Reimbursement(
//                                rs.getInt("reim_id"),
//                                re.getbyIDUser(rs.getInt("author")),
//                                re.getbyIDRes(rs.getInt("resolver")),
//                                rs.getDouble("amount"),
//                                Status.PENDING
//                        );
//
//                        reim.add(r);
//
//                    }
//
//                    return reim;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    break;
//                }
//
//            case APPROVED:
//                String approve = "select * from reimbursement where status = ?";
//                try (Connection cnt = cu.getConnection()) {
//                    PreparedStatement ps = cnt.prepareStatement(approve);
//                    ps.setString(1, String.valueOf(Status.APPROVED));
//                    ResultSet rs = ps.executeQuery();
//
//                    while (rs.next()) {
//                        Reimbursement r = new Reimbursement(
//                                rs.getInt("reim_id"),
//                                re.getbyIDUser(rs.getInt("author")),
//                                re.getbyIDRes(rs.getInt("resolver")),
//                                rs.getDouble("amount"),
//                                Status.APPROVED
//                        );
//
//                        reim.add(r);
//
//                    }
//                    return reim;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//
//                }
//
//            case DENIED:
//                String deny = "select * from reimbursement where status = ?";
//                try (Connection cnt = cu.getConnection()) {
//                    PreparedStatement ps = cnt.prepareStatement(deny);
//                    ps.setString(1, String.valueOf(Status.DENIED));
//                    ResultSet rs = ps.executeQuery();
//
//                    while (rs.next()) {
//                        Reimbursement r = new Reimbursement(
//                                rs.getInt("reim_id"),
//                                re.getbyIDUser(rs.getInt("author")),
//                                re.getbyIDRes(rs.getInt("resolver")),
//                                rs.getDouble("amount"),
//                                Status.DENIED
//                        );
//
//                        reim.add(r);
//
//                    }
//                    return reim;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//
//                }
//        }
//    return Collections.emptyList();
//    }
    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     *////"insert into managerstable values (default, ?, ?, ?) returning *"
    public void update(int id, Status status, int mId) {
        switch (status){

            case APPROVED:
        String approve = "update reimbursement set (resolver, status) = (?, 'APPROVED') where reim_id = ?";
        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(approve);
//            ps.setInt(1, unprocessedReimbursement.getId());
            ps.setInt(1, mId);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
                break;
            case DENIED:
                String Deny = "update reimbursement set (resolver, status) = (?, 'DENIED') where reim_id = ?";
                try(Connection conn = cu.getConnection()){
                    PreparedStatement ps = conn.prepareStatement(Deny);
//            ps.setInt(1, unprocessedReimbursement.getId());
                    ps.setInt(1, mId);
                    ps.setInt(2, id);
                    ResultSet rs = ps.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                break;
    }
}

    public Reimbursement insert(Reimbursement unprocessedReimbursement) {

        String sql = "insert into reimbursement (reim_id, author, amount, status, date, location, certificationtype) values (default, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, unprocessedReimbursement.getAuthor().getId());
            ps.setDouble(2, unprocessedReimbursement.getAmount());
            ps.setString(3, String.valueOf(Status.PENDING));
            ps.setString(4, unprocessedReimbursement.getDate());
            ps.setString(5, unprocessedReimbursement.getLocation());
            ps.setString(6, unprocessedReimbursement.getCertificationtype());


            ResultSet rs = ps.executeQuery();
            return unprocessedReimbursement;
        }catch(SQLException e){
            e.printStackTrace();
            return unprocessedReimbursement;
        }

    }

    public List<Reimbursement> getAll() {

        List<Reimbursement> reim = new ArrayList<>();
                String pending = "select * from reimbursement";
                try (Connection cnt = cu.getConnection()) {
                    PreparedStatement ps = cnt.prepareStatement(pending);
//                    ps.setString(1, String.valueOf(Status.PENDING));
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Reimbursement r = new Reimbursement(
                                rs.getInt("reim_id"),
                                re.getbyIDUser(rs.getInt("author")),
                                re.getbyIDRes(rs.getInt("resolver")),
                                rs.getDouble("amount"),
                                Status.valueOf(rs.getString("status")),
                                rs.getString("date"),
                                rs.getString("location"),
                                rs.getString("certificationtype")
                        );


                        reim.add(r);

                    }

                    return reim;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
        }

    public void updateAllowance(int id, double amount, String crt) {

    if(crt == "University-Course"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .80;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
}else if(crt == "Seminars"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .60;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }else if(crt == "Certification Preparation Clases"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .75;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }else if(crt == "Certification"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .100;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }else if(crt == "Technical Training"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .90;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }else if(crt == "Other"){
        String sql = "update employeestable set amount = ? where id = ?";
        double newAmount = amount * .30;
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newAmount);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    }

}
