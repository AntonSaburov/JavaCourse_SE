package com.javacourse.contact.web;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.filter.ContactFilter;

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
        contactManager = ContactManager.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ContactFilter cf = buildFilter(request);

        List<Contact> contacts = contactManager.findContacts(cf);
        request.setAttribute("CONTACT_LIST", contacts);
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private ContactFilter buildFilter(HttpServletRequest request) {
        String surName = request.getParameter("surName");
        if(surName !=null && !surName.trim().isEmpty()) {
            ContactFilter cf = new ContactFilter();
            cf.setSurName(surName);
            return cf;
        }
        return null;
    }
}
