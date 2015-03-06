package com.javacourse.contact.dao;

import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.filter.ContactFilter;

import java.util.ArrayList;
import java.util.List;

public class ContactDAOFake implements ContactDAO
{
    private List<Contact> contactList = new ArrayList<Contact>();

    @Override
    public Long addContact(Contact contact) {
        Long id = Math.round(Math.random()*1000);
        contact.setContactId(id);
        contactList.add(contact);
        return id;
    }

    @Override
    public void updateContact(Contact contact) {
    }

    @Override
    public void deleteContact(Long contactId) {
    }

    @Override
    public Contact getContact(Long contactId) {
        for(Contact c : contactList) {
            if(c.getContactId().equals(contactId)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findContact(ContactFilter filter) {
        return contactList;
    }
}
