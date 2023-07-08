package com.example.pw2;

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

    Connection conn = connect.connectDb();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String popupScript;

        try {

            query = "SELECT * FROM LOGINTABLE WHERE USERNAME=?";

            ps = conn.prepareStatement(query);
            ps.setString(1, request.getParameter("username"));
            rs = ps.executeQuery();

            if(rs.next()){  //Esiste già un utente con quel nome
                popupScript = "<script> alert('21: Errore: username già presente!'); window.location.href = 'signUp.jsp'; </script>";
            }
            else {
                query = "INSERT INTO loginTable VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                    //Genero il codice JavaScript per il popup
                    popupScript = "<script> alert('Registrazione avvenuta con successo!'); window.location.href = 'login.jsp'; </script>";
                }
                else {
                    popupScript = "<script> alert('21: Errore nella registrazione!'); window.location.href = 'signUp.jsp'; </script>";
                }
            }

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println(popupScript);

        } catch (SQLException e) {
            System.out.println("(SignUpServlet) Errore: " + e);
            throw new RuntimeException(e);
        }

    }
}
