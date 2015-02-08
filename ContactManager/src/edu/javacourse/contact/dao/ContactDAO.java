package edu.javacourse.contact.dao;

import edu.javacourse.contact.entity.Contact;
import edu.javacourse.contact.exception.ContactDAOException;
import edu.javacourse.contact.filter.ContactFilter;

import java.util.List;

public interface ContactDAO
{
    public Long addContact(Contact contact) throws ContactDAOException;
//    public void updateContact(Contact contact);
//    public void deleteContact(Long contactId);
    public Contact getContact(Long contactId);
    public List<Contact> findContact(ContactFilter filter);
}
