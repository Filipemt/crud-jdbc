package br.com.agenda.application;

import br.com.agenda.dao.ContactDAO;
import br.com.agenda.model.entities.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();


        Contact contact = new Contact();
        contact.setName("Emanuelle Mota");
        contact.setAge(16);
        contact.setRegisterDate(new Date());

        contactDAO.save(contact);


        for (Contact c : contactDAO.getContact()) {
            System.out.println(c.getName());
        }
    }
}
