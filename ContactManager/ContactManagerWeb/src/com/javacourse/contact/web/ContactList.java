package com.javacourse.contact.web;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContactList extends javax.servlet.http.HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ContactManager cm = new ContactManager();
        List<Contact> contacts = cm.findContacts(null);

        request.setAttribute("NAME", contacts);

        List<Contact> list = (List<Contact>)request.getAttribute("NAME");

        response.getWriter().write("<h1>OK</h1>");
    }
}
