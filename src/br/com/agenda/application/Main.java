package br.com.agenda.application;

import br.com.agenda.dao.ContactDAO;
import br.com.agenda.model.entities.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();

        // Create
        Contact contact = new Contact();
        contact.setName("Rafaela Mota");
        contact.setAge(13);
        contact.setRegisterDate(new Date());
        contactDAO.save(contact);

        // Read
        for (Contact c : contactDAO.getContact()) {
            System.out.println(c.getName());
        }

        // Update
        Contact contact1 = new Contact();
        contact1.setName("Rafaela Barbosa");
        contact1.setAge(14);
        contact1.setRegisterDate(new Date());
        contact1.setId(4);

        contactDAO.updateContact(contact1);

        // Delete
        Contact contact2 = new Contact();
        contact2.setId(4);

        contactDAO.deleteContactByID(contact2);
    }
}
