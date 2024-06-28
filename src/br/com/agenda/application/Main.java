package br.com.agenda.application;

import br.com.agenda.dao.ContactDAO;
import br.com.agenda.model.entities.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();

        // Create
        Contact contact = new Contact();
        contact.setName("Emanuelle Mota");
        contact.setAge(16);
        contact.setRegisterDate(new Date());
        // contactDAO.save(contact);

        // Read
        for (Contact c : contactDAO.getContact()) {
            System.out.println(c.getName());
        }

        // Update
        Contact contact1 =  new Contact();
        contact1.setName("Filipe Barbosa");
        contact1.setAge(19);
        contact1.setRegisterDate(new Date());
        contact1.setId(1);

        contactDAO.updateContact(contact1);
    }
}
