package edu.javacourse.contact;

import edu.javacourse.contact.business.ContactManager;
import edu.javacourse.contact.entity.Contact;
import edu.javacourse.contact.exception.ContactBusinessException;

import java.util.List;

public class ContactTester
{
    public static void main(String[] args) throws ContactBusinessException {
        ContactManager cm = new ContactManager();

        Contact c = createContact();

        Long id = cm.addContact(c);
        System.out.println(id);

        Contact c1 = cm.getContact(id);
        System.out.println(c1);

        List<Contact> list = cm.findContacts(null);
        if(list.size()!=1) {
            System.out.println("Error");
        }
        for(Contact ci : list) {
            System.out.println(ci);
        }
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
