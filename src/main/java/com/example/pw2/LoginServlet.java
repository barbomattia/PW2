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
        String query = "SELECT * FROM loginTable WHERE username=? AND password=?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, request.getParameter("password"));
            rs = ps.executeQuery();
            if(rs.next()){
                //Recupero la sessione
                HttpSession oldSession = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evtiare che se ne crei una nuova nel caso non ce ne sia una già esistente)
                if(oldSession != null){
                    oldSession.invalidate();    //Elimino la vecchia sessione se esistente
                }
                //Creo una nuova sessione, con i nuovi parametri username e password
                HttpSession currentSession = request.getSession();  //Di default è true, crea una nuova sessione
                currentSession.setAttribute("id", rs.getString("ID"));
                currentSession.setAttribute("username", username);
                //currentSession.setAttribute("password", rs.getString("PASSWORD"));
                currentSession.setAttribute("role", rs.getString("ROLE"));
                currentSession.setAttribute("name", rs.getString("NAME"));
                currentSession.setAttribute("surname", rs.getString("SURNAME"));
                currentSession.setAttribute("date_of_birth", rs.getDate("DATE_OF_BIRTH"));
                currentSession.setAttribute("mail", rs.getString("MAIL"));
                currentSession.setAttribute("phone_number", rs.getString("PHONE_NUMBER"));


                currentSession.setMaxInactiveInterval(5*60);    //5 minuti e poi elimina la sessione automaticamente
                //request.getRequestDispatcher(ruolo + ".jsp").forward(request, response);

                response.sendRedirect(rs.getString("ROLE") + ".jsp");
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
