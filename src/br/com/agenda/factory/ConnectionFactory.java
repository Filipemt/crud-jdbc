package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Comando2p4";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = createConnection();

        if (conn != null) {
            System.out.println("Success connection!");
            conn.close();
        }
    }
}
