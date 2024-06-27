package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.entities.Contact;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ContactDAO {

    public static void save(Contact contact) {

        String sql = """
                        INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?)
                    """;

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectionFactory.createConnection();

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, contact.getName());
            preparedStatement.setInt(2, contact.getAge());
            preparedStatement.setDate(3, new Date(contact.getRegisterDate().getTime()));

            preparedStatement.execute();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
