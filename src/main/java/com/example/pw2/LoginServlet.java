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

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    //Connection conn2 = new HelloServletDB().conn;
    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String ruolo;
        int id;
        String query = "SELECT * FROM loginTable WHERE username=? AND password=?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, request.getParameter("password"));
            rs = ps.executeQuery();
            if(rs.next()){
                ruolo = rs.getString("ROLE");    //Ruolo dell'utente
                id = rs.getInt("ID");

                //Recupero la sessione
                HttpSession oldSession = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evtiare che se ne crei una nuova nel caso non ce ne sia una già esistente)
                if(oldSession != null){
                    oldSession.invalidate();    //Elimino la vecchia sessione se esistente
                }
                //Creo una nuova sessione, con i nuovi parametri username e password
                HttpSession currentSession = request.getSession();  //Di default è true, crea una nuova sessione
                currentSession.setAttribute("id", id);
                currentSession.setAttribute("username", username);
                //currentSession.setAttribute("password", password);
                currentSession.setAttribute("role", ruolo);
                currentSession.setMaxInactiveInterval(5*60);    //5 minuti e poi elimina la sessione automaticamente
/*
                request.setAttribute("id", rs.getString("ID"));
                request.setAttribute("username", username);
                request.setAttribute("password", rs.getString("PASSWORD"));
                request.setAttribute("role", ruolo);
                request.setAttribute("name", rs.getString("NAME"));
                request.setAttribute("surname", rs.getString("SURNAME"));
                request.setAttribute("date_of_birth", rs.getDate("DATE_OF_BIRTH"));
                request.setAttribute("mail", rs.getString("MAIL"));
                request.setAttribute("phone_number", rs.getString("PHONE_NUMBER"));
 */
                //request.getRequestDispatcher(ruolo + ".jsp").forward(request, response);

                response.sendRedirect(ruolo + ".jsp");
            }
            else {
                //Torno alla pagina di login
                //PrintWriter out = response.getWriter();
                //out.println("Errore nel login");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
