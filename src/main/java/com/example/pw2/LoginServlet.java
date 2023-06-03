package com.example.pw2;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String query;

            if (!connect.isTableExists(conn, "LOGINTABLE")) {
                query = "CREATE TABLE LOGINTABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), username VARCHAR(30), password VARCHAR(30), role VARCHAR(30), name VARCHAR(30), surname VARCHAR(30), date_of_birth DATE, mail VARCHAR(70), phone_number VARCHAR(15))";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                System.out.println("Table 'loginTable' creata");
            } else {
                System.out.println("Tabella 'loginTable' già esistente");
            }

            String username = request.getParameter("username");
            query = "SELECT * FROM loginTable WHERE username=? AND password=?";

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

                if(rs.getString("ROLE").equals("amministratore")){
                    response.sendRedirect("amministratore.jsp");
                }
                else {
                    response.sendRedirect("amministratore.jsp");
                }

            }
            else {
                //Torno alla pagina di login
                System.out.println("Errore nel login");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            System.out.println("Errore: " + e);
            throw new RuntimeException(e);
        }
    }
}
