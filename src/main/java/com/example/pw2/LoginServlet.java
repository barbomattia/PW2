package com.example.pw2;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    Connection conn = connect.connectDb("Login");
    PreparedStatement ps = null, ps2 = null;
    ResultSet rs = null, rs2 = null;
    ModelSessione ms;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String query;

            String username = request.getParameter("username");
            query = "SELECT * FROM loginTable WHERE username=? AND password=?";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, request.getParameter("password"));
            rs = ps.executeQuery();

            if(rs.next()){

                HttpSession currentSession = ms.initSessione(request,rs,conn);
                //Ritorno i cookie "nome_cognome" e "menu" usati nel form contatti solo se l'utente ha consentito l'uso di cookie
                if(ModelCookies.checkCookiesAllowed(request)){
                    Cookie nome_cognome = new Cookie("nome_cognome",currentSession.getAttribute("name").toString() +  currentSession.getAttribute("surname").toString());
                    Cookie mail = new Cookie("mail", currentSession.getAttribute("mail").toString());
                    nome_cognome.setMaxAge(5*60);   // stessa età della sessione
                    mail.setMaxAge(5*60);
                    response.addCookie(nome_cognome);
                    response.addCookie(mail);
                }

                currentSession.setMaxInactiveInterval(5*60);    //5 minuti e poi elimina la sessione automaticamente

                String encodedURL;
                if(rs.getString("ROLE").equals("amministratore")){
                    encodedURL = response.encodeRedirectURL("amministratore.jsp");
                }
                else {
                    encodedURL = response.encodeRedirectURL("profilo.jsp");
                }


                FilterCheckLogin.setAttribute(request, currentSession);

                RequestDispatcher requestDispatcher;
                requestDispatcher=request.getRequestDispatcher(encodedURL);
                requestDispatcher.forward(request, response);
            }

            else {
                //Torno alla pagina di login
                //String popupScript = "<script> alert('21: Account inesistente'); window.location.href = 'login.jsp'; </script>";
                String popupScript ="<script> \n" +
                        "testo_errore = document.createElement(\"h3\")\n" +
                        "testo_errore.innerText = \"21: Account inesistente\" \n" +
                        "testo_errore.style.color = \"red\" \n" +
                        "testo_errore.style.textAlign=\"center\" \n"+
                        "testo_errore.style.margin = \"0\" \n"+
                        "testo_errore.style.padding = \"0\" \n"+
                        "var form = document.getElementById(\"formLogin\") \n" +
                        "form.appendChild(testo_errore) \n" +
                        "</script>";
                response.setContentType("text/html");

                RequestDispatcher requestDispatcher;
                requestDispatcher=request.getRequestDispatcher("login.jsp");
                requestDispatcher.include(request, response);

                PrintWriter out = response.getWriter();
                out.println(popupScript);
            }


        } catch (SQLException e) {
            System.out.println("Errore: " + e);
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() { super.destroy(); connect.closeConnection(conn); }



}

