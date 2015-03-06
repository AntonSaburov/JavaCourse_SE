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
    private ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getDAO();
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
    }

    public Contact getContact(Long contactId) {
        return dao.getContact(contactId);
    }

    public List<Contact> findContacts(ContactFilter filter) {
        return dao.findContact(filter);
    }
}
