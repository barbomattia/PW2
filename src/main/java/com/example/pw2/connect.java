package com.example.pw2;

import java.sql.*;


public class connect {

    public static Connection connectdb() {
        Connection conn;
        try {
            System.out.println("Tentativo di connessione");
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDerbyDB;create=true");
            initDataBase(conn);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {  //
            System.out.println("Connessione fallita");
            ex.printStackTrace();
        }
        return null;
    }

    //Va invocata passando il parametro conn, non si può rendere quello sopra globale poichè è statico all'interno del costruttore
    //L'ho inserito in questa classe in quanto metodo generico utilizzato da più servlet
    public static boolean isTableExists(Connection connection, String tableName) throws SQLException {
        ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);
        return resultSet.next();
    }

    private static void initDataBase(Connection connection) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        if (!isTableExists(connection, "FRASITABLE")) {
            String queryCreazione = "CREATE TABLE FRASITABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), frase VARCHAR(100), cit VARCHAR(50))";
            ps = connection.prepareStatement(queryCreazione);
            ps.executeUpdate();
            System.out.println("Table 'FRASITABLE' creata");


            String queryInizializzazione = "INSERT INTO loginTable VALUES (DEFAULT, ?, ?)";

            try {
                ps.executeUpdate("INSERT INTO FRASITABLE " + "VALUES (DEFAULT,'Fare volontariato fa bene all’anima e al cuore', '(Roy Disney)')");
                ps.executeUpdate("INSERT INTO FRASITABLE " + "VALUES (DEFAULT,'Là dove c’è un volontario, c’è umanità e speranza', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE " + "VALUES (DEFAULT,'Quello che per altri è perdita di tempo per me è vita', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE " + "VALUES (DEFAULT,'Tutti hanno la responsabilità di essere volontari da qualche parte', '(Jennifer Garner)')");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("Tabella 'FRASITABLE' già esistente");
        }


    }

}

