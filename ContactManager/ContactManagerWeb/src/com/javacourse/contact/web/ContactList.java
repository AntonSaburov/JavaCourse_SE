package com.javacourse.contact.web;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContactList extends javax.servlet.http.HttpServlet
{
    private ContactManager contactManager;

    @Override
    public void init() throws ServletException {
        contactManager = new ContactManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Contact> contacts = contactManager.findContacts(null);
        request.setAttribute("CONTACT_LIST", contacts);
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
