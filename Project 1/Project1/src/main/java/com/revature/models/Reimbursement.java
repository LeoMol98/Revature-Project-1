package com.revature.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */


public class Reimbursement extends AbstractReimbursement {

    public String date;
    public String location;
    public String certificationtype;
//    public Reimbursement(int reim_id, String status, String resolver, double amount) {
//        super();
//    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
    public Reimbursement(int id, User author, User resolver, double amount, Status status, String date, String location, String certificationtype) {
        super(id, author, resolver, amount, status);
        this.date = date;
        this.location = location;
        this.certificationtype = certificationtype;
    }
    public Reimbursement(User author, User resolver, double amount, Status status) {
        super(author, resolver, amount, status);
    }
    public Reimbursement(int id, Status status) {
        super(id, status);
    }

//    public Reimbursement(String status, Optional<User> getbyID, Optional<User> resolver, double amount) {
//    }
//    public Reimbursement(int id, Status status, String Author, String Resolver, double amount) {
//        super(id, status, amount);
//        this.Author = Author;
//        this.Resolver = Resolver;
//    }
public Reimbursement(User author, double amount, Status status, String date, String location, String certificationtype ) {
    super(author, amount, status);
    this.date = date;
    this.location = location;
    this.certificationtype = certificationtype;
}

    public Reimbursement() {

    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCertificationtype() {
        return certificationtype;
    }

    public void setCertificationtype(String certificationtype) {
        this.certificationtype = certificationtype;
    }
}
//    insert into users (first_name, last_name) values ('Jess', 'Felleman');