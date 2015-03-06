package com.javacourse.contact.dao;

import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.exception.ContactDAOException;
import com.javacourse.contact.filter.ContactFilter;

import java.util.List;

public interface ContactDAO
{
    public Long addContact(Contact contact) throws ContactDAOException;
    public void updateContact(Contact contact);
    public void deleteContact(Long contactId);
    public Contact getContact(Long contactId);
    public List<Contact> findContact(ContactFilter filter);
}
