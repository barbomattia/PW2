package com.example.pw2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DonazioniNavettaModel {

    static int donazioni;

    public DonazioniNavettaModel() {}

    // Metodo per scaricare il dato delle donazione per la navetta dal database
    private void takeDonazioniNavettaFromDB(Connection conn){
        // prendo dal DataBase le donazioni navette

        try{
            Statement stant = conn.createStatement();                  // creo il Statment
            String sql ="SELECT * FROM DONAZIONINAVETTATABLE";         // definisco la query
            ResultSet resultSet = stant.executeQuery(sql);             // eseguo la query e salvo la risposta

            while(resultSet.next()){
                donazioni = resultSet.getInt(1);      //Leggo e salvo le donazioni presenti
            }

            //System.out.println(donazioni);
            //System.out.println(conn);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setDonazioniNavetta(Connection conn, int improve){

        try{
            takeDonazioniNavettaFromDB(conn);            // riscarico il valore delle donazioni nella servlet per evitare errori
            donazioni = donazioni + improve;             // aggiorno il valore

            //System.out.println(donazioni);

            Statement stant = conn.createStatement();                                        // creo il Statment
            String sql ="UPDATE DONAZIONINAVETTATABLE SET DONAZIONI = " + donazioni;         // definisco la query
            stant.executeUpdate(sql);                                                        // eseguo la query

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // metodo da chiamare per ritornare le donazioni per la navetta
    public int getDonazioniNavetta(Connection conn){
        takeDonazioniNavettaFromDB(conn);
        return donazioni;
    }

}
