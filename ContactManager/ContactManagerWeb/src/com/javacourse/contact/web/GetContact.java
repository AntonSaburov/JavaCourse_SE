package com.javacourse.contact.web;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Антон on 12.03.2015.
 */
public class GetContact extends HttpServlet
{
    private ContactManager contactManager;

    @Override
    public void init() throws ServletException {
        contactManager = ContactManager.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String cIdStr = request.getParameter("contactId");
        if (cIdStr != null && !cIdStr.trim().isEmpty()) {
            try {
                Long contactId = Long.parseLong(cIdStr);
                Contact contact = contactManager.getContact(contactId);
                request.setAttribute("CONTACT", contact);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
