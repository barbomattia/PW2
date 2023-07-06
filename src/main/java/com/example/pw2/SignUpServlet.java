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

@WebServlet(name = "SignUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = "INSERT INTO loginTable VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, request.getParameter("username"));
            ps.setString(2, request.getParameter("password"));
            ps.setString(3, request.getParameter("role"));
            ps.setString(4, request.getParameter("name"));
            ps.setString(5, request.getParameter("surname"));
            ps.setString(6, request.getParameter("birth"));
            ps.setString(7, request.getParameter("mail"));
            ps.setString(8, request.getParameter("phone_number"));

            if(ps.executeUpdate() > 0){
                //response.sendRedirect("login.jsp");
                // Genera il codice JavaScript per il popup
                String popupScript = "<script>"
                                    + "alert('Registrazione avvenuta con successo!');"
                                    + "window.location.href = 'login.jsp';"
                                    + "</script>";

                // Imposta il tipo di contenuto della risposta come HTML
                response.setContentType("text/html");

                // Ottiene lo stream di output della risposta
                PrintWriter out = response.getWriter();

                // Scrive il codice JavaScript nel corpo della risposta
                out.println(popupScript);
            }
            else {
                System.out.println("Errore nella registrazione");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
