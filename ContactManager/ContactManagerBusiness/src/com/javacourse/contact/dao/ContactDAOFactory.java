package com.javacourse.contact.dao;

import java.util.PropertyResourceBundle;

public class ContactDAOFactory
{
    private static PropertyResourceBundle props;

    static {
        props = (PropertyResourceBundle) PropertyResourceBundle.getBundle("ContactDAO");
    }

    public static ContactDAO getDAO() {
        try {
            Class classDefinition = Class.forName(props.getString("contact.dao.class"));
            return (ContactDAO)classDefinition.newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
