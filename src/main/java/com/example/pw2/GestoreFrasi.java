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

    String[] frasi;   // array delle frasi
    String[] cit;     // array delle citazioni delle frasi

    @Override
    public void init() throws ServletException {
        super.init();

        // prendo dal DataBase le frasi e citazioni da mostrare
        Connection conn = connect.connectdb();

        try {
            Statement stant = conn.createStatement();       // creo il Statment
            String sql ="SELECT * FROM FRASITABLE";         // definisco la query
            ResultSet resultSet = stant.executeQuery(sql);  // eseguo la query e salvo la risposta

            ArrayList<String> listFrasi = new ArrayList<>();        // uso degli ArrayList per facilitare la lettura della risposta
            ArrayList<String> listCit = new ArrayList<>();

            while(resultSet.next()){
                listFrasi.add(resultSet.getString(2));      //Leggo e salvo le frasi
                listCit.add(resultSet.getString(3));        //Leggo e salvo le citazioni
            }

            frasi = listFrasi.toArray(new String[listFrasi.size()]);    //ripongo i contenuti degli ArrayList negli array
            cit = listCit.toArray(new String[listCit.size()]);

            //System.out.println(listFrasi);
            //System.out.println(Arrays.toString(frasi));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GETSORE CHIAMAT0");
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
    }
}
