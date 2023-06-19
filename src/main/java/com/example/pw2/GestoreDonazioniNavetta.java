package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "GestoreDonazioniNavette", urlPatterns ={"/GestoreDonazioniNavetta"} )
public class GestoreDonazioniNavetta extends HttpServlet {

    Connection conn;
    int donazioniNavetta;
    int obbiettivoDonazioni = 100000;

    @Override
    public void init() throws ServletException {
        super.init();

        // prendo dal DataBase le donazioni navette
        Connection conn = connect.connectdb();

        try{
            Statement stant = conn.createStatement();                  // creo il Statment
            String sql ="SELECT * FROM DONAZIONINAVETTATABLE";         // definisco la query
            ResultSet resultSet = stant.executeQuery(sql);             // eseguo la query e salvo la risposta

            while(resultSet.next()){
                donazioniNavetta = resultSet.getInt(1);      //Leggo e salvo le donazioni presenti
            }

            System.out.println(donazioniNavetta);
            System.out.println(conn);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        System.out.println(conn);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("GET "+ conn);

        // elamborazione dati
        float perc = ((float)donazioniNavetta /obbiettivoDonazioni) *100;   // caloclo la percentuale
        float percDonazioni = (float) (Math.round(perc*100)/100.0);         // arrotondo la percentuale a 2 cifre dopo la virgola
        request.setAttribute("percDonazioni",percDonazioni);             // inserisco nella richiesta la percentuale calcolata

        // chiama il file JSP per la parte view
        try{
            RequestDispatcher requestDispatcher;
            requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
            requestDispatcher.forward(request, response);
        }
        catch( Exception ex){
            System.out.println("Error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int improve = Integer.valueOf(request.getParameter("importo"));
        System.out.println("improve: " + improve);

        // aumetno le donazioni totali
        updateDonNav(improve);

        float perc = ((float)donazioniNavetta /obbiettivoDonazioni) *100;   // trovo la percentuale
        float percDonazioni = (float) (Math.round(perc*100)/100.0);         // arrotondo la percentuale
        request.setAttribute("percDonazioni",percDonazioni);


        RequestDispatcher requestDispatcher;
        requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void getDonNav(){

        Connection conn = connect.connectdb();

        try{
            Statement stant = conn.createStatement();                  // creo il Statment
            String sql ="SELECT * FROM DONAZIONINAVETTATABLE";         // definisco la query
            ResultSet resultSet = stant.executeQuery(sql);             // eseguo la query e salvo la risposta

            while(resultSet.next()){
                donazioniNavetta = resultSet.getInt(1);      //Leggo e salvo le donazioni presenti
            }

            System.out.println(donazioniNavetta);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    protected void updateDonNav( int improve ){

        Connection conn = connect.connectdb();

        try{
            getDonNav();                                               // riscarico il valore delle donazioni nella servlet per evitare errori
            donazioniNavetta = donazioniNavetta + improve;             // aggiorno il valore

            Statement stant = conn.createStatement();                                               // creo il Statment
            String sql ="UPDATE DONAZIONINAVETTATABLE SET DONAZIONI = " + donazioniNavetta;         // definisco la query
            stant.executeUpdate(sql);                                                               // eseguo la query

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void destroy(){
        connect.closeConnection(conn);  //chiudo la connessione
        super.destroy();
    }
}
