package com.javacourse.contact.business;

import com.javacourse.contact.dao.ContactDAO;
import com.javacourse.contact.dao.ContactDAOFactory;
import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.exception.ContactBusinessException;
import com.javacourse.contact.exception.ContactDAOException;
import com.javacourse.contact.filter.ContactFilter;

import java.util.List;

public class ContactManager
{
    private static ContactManager instance;

    private ContactDAO dao;

    private ContactManager() {
        dao = ContactDAOFactory.getDAO();
    }

    public synchronized static ContactManager getInstance() {
        if(instance == null) {
           instance = new ContactManager();
        }
        return instance;
    }

    public Long addContact(Contact contact) throws ContactBusinessException {
        try {
            Long id = dao.addContact(contact);
            return id;
        } catch(ContactDAOException ex) {
            throw new ContactBusinessException("", ex);
        }
    }

    public void updateContact(Contact contact) {
        dao.updateContact(contact);
    }

    public void deleteContact(Long contactId) {
        dao.deleteContact(contactId);
    }

    public Contact getContact(Long contactId) {
        return dao.getContact(contactId);
    }

    public List<Contact> findContacts(ContactFilter filter) {
        return dao.findContact(filter);
    }
}
