package com.javacourse.contact.web;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.exception.ContactBusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddContact extends HttpServlet
{
    private ContactManager contactManager;

    @Override
    public void init() throws ServletException {
        contactManager = ContactManager.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Contact contact = createContact(request);
        try {
            if(contact.getContactId()==null) {
                contactManager.addContact(contact);
            } else {
                contactManager.updateContact(contact);
            }
            response.sendRedirect("list");
        } catch (ContactBusinessException e) {
            e.printStackTrace();
        }
    }

    private Contact createContact(HttpServletRequest request) {
        String cntId = request.getParameter("contactId");
        Long contactId = null;
        if(cntId !=null && !cntId.trim().isEmpty()) {
            contactId = Long.parseLong(cntId);
        }
        String surName = request.getParameter("surName");
        String givenName = request.getParameter("givenName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Contact cnt = new Contact();
        cnt.setContactId(contactId);
        cnt.setSurName(surName);
        cnt.setGivenName(givenName);
        cnt.setEmail(email);
        cnt.setPhone(phone);
        return cnt;
    }
}
