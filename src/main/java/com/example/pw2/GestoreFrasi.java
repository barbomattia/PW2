package com.example.pw2;



import org.json.JSONObject;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GestoreFrasi", value = "/GestoreFrasi")
public class GestoreFrasi extends HttpServlet {

    Connection conn;
    FrasiModel fm;
    String[] frasi;   // array delle frasi
    String[] cit;     // array delle citazioni delle frasi

    @Override
    public void init() throws ServletException {
        super.init();

        // prendo dal DataBase le frasi e citazioni da mostrare
        Connection conn = connect.connectdb();
        fm = new FrasiModel(conn);
        frasi= fm.getFrasi();
        cit=fm.getCit();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("GETSORE FRASI CHIAMAT0");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //allego alla risposta le frasi e le citazioni
        try(PrintWriter out = response.getWriter()){

            //definisco l'oggetto che contiene gli array
            JSONObject contenuto = new JSONObject();
            contenuto.put("frasi",frasi);
            contenuto.put("cit",cit);


            //inserisco gli array nella risposta
            out.println(contenuto);
            out.flush();

        }catch (IOException ex){
            System.out.println(ex);
            response.sendRedirect("error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy(){
        connect.closeConnection(conn);
    } //chiudo la connessione
}
