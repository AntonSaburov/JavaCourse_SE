package edu.javacourse.contact.business;

import edu.javacourse.contact.dao.ContactDAO;
import edu.javacourse.contact.dao.ContactDAOFactory;
import edu.javacourse.contact.entity.Contact;
import edu.javacourse.contact.exception.ContactBusinessException;
import edu.javacourse.contact.exception.ContactDAOException;
import edu.javacourse.contact.filter.ContactFilter;

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
