package com.example.pw2;


import java.sql.*;

public class connect {

    public static Connection connectdb() {
        Connection conn;
        try {
            System.out.println("Tentativo di connessione");
            Class.forName("org.apache.derby.jdbc.ClientDriver");                                // definisco il Driver
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DataBasePW;create=true");// creo la connessione
            System.out.println("Connesso");
            initDataBase(conn);             // inizializzo il database
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connessione fallita");
            ex.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection conn){
        try{
            conn.close();
            System.out.println("Connessione chiusa correttamente");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Va invocata passando il parametro conn, non si può rendere quello sopra globale poichè è statico all'interno del costruttore
    //L'ho inserito in questa classe in quanto metodo generico utilizzato da più servlet
    public static boolean isTableExists(Connection connection, String tableName) throws SQLException {
        ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);
        return resultSet.next();
    }

    private static void initDataBase(Connection connection) throws SQLException {

        Statement ps = null;

        if (!isTableExists(connection, "FRASITABLE")) {     // controllo che non sia gia stata creata la tabella
            String queryCreazione = "CREATE TABLE FRASITABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), frase VARCHAR(100), cit VARCHAR(50))"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
            System.out.println("Table 'FRASITABLE' creata");

            try {                                           // Inizializzo la tabella
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Fare volontariato fa bene all’anima e al cuore', '(Roy Disney)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Là dove c’è un volontario, c’è umanità e speranza', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Quello che per altri è perdita di tempo per me è vita', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Tutti hanno la responsabilità di essere volontari da qualche parte', '(Jennifer Garner)')");

            } catch (SQLException e) {
                System.out.println("Errore inizializzazione FRASITABLE" + e);
                throw new RuntimeException(e);
            }
            System.out.println("Table 'FRASITABLE' inizializzata");


        } else {
            System.out.println("Tabella 'FRASITABLE' già esistente");
        }


    }

}

