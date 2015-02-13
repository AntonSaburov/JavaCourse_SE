package edu.javacourse.contact.dao;

import edu.javacourse.contact.entity.Contact;
import edu.javacourse.contact.exception.ContactDAOException;
import edu.javacourse.contact.filter.ContactFilter;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ContactDAOFileSrl implements ContactDAO {
    private static final String FILE_NAME = "contact.srl";

    @Override
    public Long addContact(Contact contact) throws ContactDAOException {
        contact.setContactId(System.currentTimeMillis());

        File file = new File(FILE_NAME);
        List<Contact> result;
        if (file.exists()) {
            result = findContact(null);
        } else {
            result = new LinkedList<Contact>();
        }
        if (result != null) {
            result.add(contact);
            try {
                saveListToFile(result);
                return contact.getContactId();
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
                throw new ContactDAOException(ex);
            }
        }
        throw new ContactDAOException("Error to load Contact");
    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Long contactId) {

    }

    @Override
    public Contact getContact(Long contactId) {
        return null;
    }

    @Override
    public List<Contact> findContact(ContactFilter filter) {
        try {
            return loadListFromFile();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    private void saveListToFile(List<Contact> list) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    private List<Contact> loadListFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Contact> result = (List<Contact>) ois.readObject();
        ois.close();
        return result;
    }
}
