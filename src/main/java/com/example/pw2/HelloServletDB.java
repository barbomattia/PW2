package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "HelloServletDB", value = "/HelloServletDB")
public class HelloServletDB extends HttpServlet {

    String dbURL = "jdbc:derby://localhost:1527/MyDerbyDB;create=true;";

    String user = "App";

    String password = "kante";

    Connection conn = null;

    HelloServletDB() {
        /*
        try{
            System.out.println("Tentativo di connessione - HelloServletDB - 1");
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException ex){  //ClassNotFoundException |
            System.out.println("Errore di connessione - HelloServletDB - 1");
            System.out.println(ex);
        }

         */



        try{
            System.out.println("Tentativo di connessione - HelloServletDB - 2");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDerbyDB;create=true");
        } catch (ClassNotFoundException | SQLException ex){  //
            System.out.println("Errore di connessione - HelloServletDB - 2");
            System.out.println(ex);
        }



    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        StringBuffer dbOutput = new StringBuffer("<h1>");
        try{
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM FIRSTTABLE";
            ResultSet results = stmt.executeQuery(sql);
            while (results.next()){
                dbOutput.append(results.getInt(1)).append(" - ");
                dbOutput.append(results.getString(2)).append("</h1><h1>");
            }
            dbOutput.append("</h1>");
            results.close();
            stmt.close();
        } catch (SQLException | NullPointerException ex){
            dbOutput.append(ex.toString()).append("</h1>");
        }

        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html><html><head>");
            out.println("<title>Servlet TheServlet</title>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void destroy(){
        try{
            conn.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
