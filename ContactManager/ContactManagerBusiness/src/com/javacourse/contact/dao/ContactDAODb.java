package com.javacourse.contact.dao;

import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.exception.ContactDAOException;
import com.javacourse.contact.filter.ContactFilter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ContactDAODb implements ContactDAO
{
    private static final String SELECT = "SELECT * FROM cm_contact ORDER BY sur_name, given_name";
    private static final String INSERT = "INSERT INTO cm_contact (sur_name, given_name, email, phone) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE cm_contact SET sur_name=?, given_name=?, email=?, phone=? WHERE contact_id=?";

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private Connection getConnection() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/jvacourse";
//        return DriverManager.getConnection(url, "postgres", "postgres");
        try {
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/regionDS");
//            DataSource dataSource = (DataSource) ctx.lookup("jdbc/regionDS");
            Connection con = dataSource.getConnection();
            return con;
        } catch (NamingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Long addContact(Contact contact) throws ContactDAOException {
        Long contactId = 0L;
        try {
            Connection con = getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(INSERT, new String[] {"contact_id"} );
                stmt.setString(1, contact.getSurName());
                stmt.setString(2, contact.getGivenName());
                stmt.setString(3, contact.getEmail());
                stmt.setString(4, contact.getPhone());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    contactId = rs.getLong("contact_id");
                    contact.setContactId(contactId);
                }
                rs.close();

                stmt.close();
            } finally {
                con.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        return contactId;
    }

    @Override
    public void updateContact(Contact contact) {
        try {
            Connection con = getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(UPDATE);
                stmt.setString(1, contact.getSurName());
                stmt.setString(2, contact.getGivenName());
                stmt.setString(3, contact.getEmail());
                stmt.setString(4, contact.getPhone());
                stmt.setLong(5, contact.getContactId());
                stmt.executeUpdate();
                stmt.close();
            } finally {
                con.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
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
                ResultSet rs = stmt.executeQuery(SELECT);
                while(rs.next()) {
                    Contact cnt = new Contact();
                    cnt.setContactId(rs.getLong("contact_id"));
                    cnt.setGivenName(rs.getString("given_name"));
                    cnt.setSurName(rs.getString("sur_name"));
                    cnt.setEmail(rs.getString("email"));
                    cnt.setPhone(rs.getString("phone"));
                    result.add(cnt);
                }
                stmt.close();
                rs.close();
            } finally {
                con.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }
}
