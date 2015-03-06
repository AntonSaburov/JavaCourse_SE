package com.javacourse.contact;

import com.javacourse.contact.business.ContactManager;
import com.javacourse.contact.entity.Contact;
import com.javacourse.contact.exception.ContactBusinessException;

import java.util.List;

public class ContactTester
{
    public static void main(String[] args) throws ContactBusinessException {
        ContactManager cm = new ContactManager();

        Contact nc = createContact();
        cm.addContact(nc);
        System.out.println(nc.getContactId());

        List<Contact> list = cm.findContacts(null);
        for(Contact ci : list) {
            System.out.println(ci);
        }

        Contact c = list.get(0);
        c.setEmail("ivan@google.com");
        cm.updateContact(c);
    }

    public static Contact createContact() {
        Contact c = new Contact();
        c.setSurName("Sidorov");
        c.setGivenName("Ivan");
        c.setEmail("Ivan@pisem.net");
        c.setPhone("+7-921-111-4444");
        return c;
    }
}
