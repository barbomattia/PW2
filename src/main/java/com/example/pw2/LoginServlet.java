package com.example.pw2;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    Connection conn = connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    ModelCookies mc;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String query;
/*
            if (!connect.isTableExists(conn, "LOGINTABLE")) {
                query = "CREATE TABLE LOGINTABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), username VARCHAR(30), password VARCHAR(30), role VARCHAR(30), name VARCHAR(30), surname VARCHAR(30), date_of_birth DATE, mail VARCHAR(70), phone_number VARCHAR(15))";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                System.out.println("Table 'loginTable' creata");
            } else {
                System.out.println("Tabella 'loginTable' già esistente");
            }
 */
            String username = request.getParameter("username");
            query = "SELECT * FROM loginTable WHERE username=? AND password=?";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, request.getParameter("password"));
            rs = ps.executeQuery();
            if(rs.next()){
                //Recupero la sessione
                HttpSession oldSession = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evitare che se ne crei una nuova nel caso non ce ne sia una già esistente)
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
                currentSession.setAttribute("date_of_birth", rs.getDate("BIRTH"));
                currentSession.setAttribute("mail", rs.getString("MAIL"));
                currentSession.setAttribute("phone_number", rs.getString("PHONE_NUMBER"));
                currentSession.setAttribute("logged",true);

                //Ritorno i cookie "nome_cognome" e "menu" usati nel form contatti solo se l'utente ha consentito l'uso di cookie
                if(mc.checkCookiesAllowed(request)){
                    Cookie nome_cognome = new Cookie("nome_cognome",currentSession.getAttribute("name").toString() +  currentSession.getAttribute("surname").toString());
                    Cookie mail = new Cookie("mail", currentSession.getAttribute("mail").toString());
                    nome_cognome.setMaxAge(5*60);   // stessa età della sessione
                    mail.setMaxAge(5*60);
                    response.addCookie(nome_cognome);
                    response.addCookie(mail);
                }


                currentSession.setMaxInactiveInterval(5*60);    //cinque minuti e poi elimina la sessione automaticamente
                //request.getRequestDispatcher(ruolo + ".jsp").forward(request, response);


                String encodedURL="";
                if(rs.getString("ROLE").equals("amministratore")){
                    encodedURL = response.encodeRedirectURL("amministratore.jsp");
                }
                else {
                    encodedURL = response.encodeRedirectURL("profilo.jsp");
                }


                request.setAttribute("id",currentSession.getAttribute("id"));
                request.setAttribute("username",currentSession.getAttribute("username"));
                request.setAttribute("role",currentSession.getAttribute("role"));
                request.setAttribute("name",currentSession.getAttribute("name"));
                request.setAttribute("surname",currentSession.getAttribute("surname"));
                request.setAttribute("date_of_birth",currentSession.getAttribute("date_of_birth"));
                request.setAttribute("mail",currentSession.getAttribute("mail"));
                request.setAttribute("phone_number",currentSession.getAttribute("phone_number"));

                RequestDispatcher requestDispatcher;
                requestDispatcher=request.getRequestDispatcher(encodedURL);
                requestDispatcher.forward(request, response);
            }

            else {
                //Torno alla pagina di login
                System.out.println("Errore nel login, nessuna corrispondenza per: username=" + username + ", password=" + request.getParameter("password"));
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            System.out.println("Errore: " + e);
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }





}

