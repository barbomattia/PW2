package com.example.pw2;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
