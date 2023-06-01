package com.example.pw2;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "DatiPersonaliServlet", value = "/visualizzaDatiPersonali")
public class DatiPersonaliServlet extends HttpServlet {

    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Dentro il GET di DatiPersonaliServlet");

        //Recupero la sessione
        HttpSession session = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evtiare che se ne crei una nuova nel caso non ce ne sia una già esistente)
        if(session==null){
            System.out.println("Sessione non esistente");
            response.sendRedirect("login.jsp"); //Se non c'è una sessione attiva, rimando l'utente alla pagina di login
        }
        System.out.println("Sessione esistente");

        int id = (int) session.getAttribute("id");
        String query = "SELECT * FROM loginTable WHERE id=?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Trovato utente con id = " + id);
                //Creo un insieme di dati da restituire al javascript
                //A sto punto conviene salvare tutto nella sessione?


                try {

                    String jsonPovero = "{";
                    jsonPovero += '"' + "ID" + '"' + ":" + '"' + rs.getString("ID") + '"' +  ",";
                    jsonPovero += '"' + "username" + '"' + ":" + '"' + rs.getString("USERNAME") + '"' +  ",";
                    jsonPovero += '"' + "password" + '"' + ":" + '"' + rs.getString("PASSWORD") + '"' +  ",";
                    jsonPovero += '"' + "role" + '"' + ":" + '"' + rs.getString("ROLE") + '"' +  ",";
                    jsonPovero += '"' + "name" + '"' + ":" + '"' + rs.getString("NAME") + '"' +  ",";
                    jsonPovero += '"' + "surname" + '"' + ":" + '"' + rs.getString("SURNAME") + '"' +  ",";
                    jsonPovero += '"' + "date_of_birth" + '"' + ":" + '"' + rs.getString("DATE_OF_BIRTH") + '"' +  ",";
                    jsonPovero += '"' + "mail" + '"' + ":" + '"' + rs.getString("MAIL") + '"' +  ",";
                    jsonPovero += '"' + "phone_number" + '"' + ":" + '"' + rs.getString("PHONE_NUMBER") + '"';
                    jsonPovero += "}";

                    System.out.println("JsonPovero = " + jsonPovero);



                    Map<String, Object> data = new HashMap<>();

                    data.put("username", rs.getString("USERNAME"));
                    data.put("password", rs.getString("PASSWORD"));
                    data.put("role", rs.getString("ROLE"));
                    data.put("name", rs.getString("NAME"));
                    data.put("surname", rs.getString("SURNAME"));
                    data.put("date_of_birth", rs.getDate("DATE_OF_BIRTH"));
                    data.put("mail", rs.getString("MAIL"));
                    data.put("phone_number", rs.getString("PHONE_NUMBER"));

                    System.out.println(data);

                    PrintWriter out = response.getWriter();
                    out.print(jsonPovero);
                    out.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //request.getRequestDispatcher("simpatizzante.jsp").forward(request, response);
            }
            else {
                //Non è stato trovato un id corrispondente, quindi torno alla pagina di login
                System.out.println("Nessun utente trovato");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            System.out.println("Errorino erroretto");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Dentro la doPost di DatiPersonaliServlet");

        //Recupero la sessione
        HttpSession session = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evtiare che se ne crei una nuova nel caso non ce ne sia una già esistente)
        if(session==null){
            System.out.println("Sessione non esistente");
            response.sendRedirect("login.jsp"); //Se non c'è una sessione attiva, rimando l'utente alla pagina di login
        }

        System.out.println("Sessione esistente");

        int id = (int) session.getAttribute("id");
        String query = "SELECT * FROM loginTable WHERE id=?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Trovato utente con id = " + id);
                request.setAttribute("username", rs.getString("USERNAME"));
                request.setAttribute("password", rs.getString("PASSWORD"));
                request.setAttribute("role", rs.getString("ROLE"));
                request.setAttribute("name", rs.getString("NAME"));
                request.setAttribute("surname", rs.getString("SURNAME"));
                request.setAttribute("date_of_birth", rs.getDate("DATE_OF_BIRTH"));
                request.setAttribute("mail", rs.getString("MAIL"));
                request.setAttribute("phone_number", rs.getString("PHONE_NUMBER"));
                request.getRequestDispatcher("simpatizzante.jsp").forward(request, response);
            }
            else {
                //Non è stato trovato un id corrispondente, quindi torno alla pagina di login
                System.out.println("Nessun utente trovato");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
