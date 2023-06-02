package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DatiPersonaliServlet", value = "/visualizzaDatiPersonali")
public class DatiPersonaliServlet extends HttpServlet {

    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
