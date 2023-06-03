package com.example.pw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connect {

    public static Connection connectdb() {
        Connection conn = null;
        try {
            System.out.println("Tentativo di connessione");
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDerbyDB;create=true");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {  //
            System.out.println("Connessione fallita");
            System.out.println(ex);
        }
        return null;
    }

    //Va invocata passando il parametro conn, non si può rendere quello sopra globale poichè è statico all'interno del costruttore
    //L'ho inserito in questa classe in quanto metodo generico utilizzato da più servlet
    public static boolean isTableExists(Connection connection, String tableName) throws SQLException {
        ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);
        return resultSet.next();
    }

}

