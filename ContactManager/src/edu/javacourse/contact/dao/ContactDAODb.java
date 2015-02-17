package edu.javacourse.contact.dao;

import edu.javacourse.contact.entity.Contact;
import edu.javacourse.contact.exception.ContactDAOException;
import edu.javacourse.contact.filter.ContactFilter;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ContactDAODb implements ContactDAO
{
    static {
        try {
            Class.forName("org.postgresql.Drive");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/jvacourse";
        return DriverManager.getConnection(url, "postgres", "postgres");
    }

    @Override
    public Long addContact(Contact contact) throws ContactDAOException {
        return null;
    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Long contactId) {

    }

    @Override
    public Contact getContact(Long contactId) {
        return null;
    }

    @Override
    public List<Contact> findContact(ContactFilter filter) {
        List<Contact> result = new LinkedList<Contact>();
        try {
            Connection con = getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Contact");
                while(rs.next()) {
                    Contact cnt = new Contact();
                    cnt.setContactId(rs.getLong("contact_id"));
                    cnt.setGivenName(rs.getString("given_name"));
                    cnt.setSurName(rs.getString("sur_name"));
                    cnt.setEmail(rs.getString("emaile"));
                    cnt.setPhone(rs.getString("phone"));
                    result.add(cnt);
                }
            } finally {
                con.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }
}
