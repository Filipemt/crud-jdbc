package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.entities.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void updateContact(Contact contact) {
        String sql = """
                        UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?
                        WHERE id = ?
                    """;

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectionFactory.createConnection();

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, contact.getName());
            preparedStatement.setInt(2, contact.getAge());
            preparedStatement.setDate(3, new Date(contact.getRegisterDate().getTime()));

            preparedStatement.setInt(4, contact.getId());

            preparedStatement.execute();
        }  catch (Exception e) {
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

    public List<Contact> getContact(){
        String sql = """
                        SELECT * FROM contatos
                    """;

        List<Contact> contactList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionFactory.createConnection();

            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("nome"));
                contact.setAge(resultSet.getInt("idade"));
                contact.setRegisterDate(resultSet.getDate("dataCadastro"));

                contactList.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return contactList;
    }

    public void deleteContactByID(Contact contact) {
        String sql = """
                    DELETE FROM contatos WHERE id = ?
                    """;

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectionFactory.createConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, contact.getId());

            preparedStatement.execute();
            System.out.println("Contact deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement  != null) {
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
