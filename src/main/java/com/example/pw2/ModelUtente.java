package com.example.pw2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelUtente {

    public static void registraNuovoUtente(Connection conn, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query;
        String popupScript;

        query = "SELECT * FROM LOGINTABLE WHERE USERNAME=?";

        ps = conn.prepareStatement(query);
        ps.setString(1, request.getParameter("username"));
        rs = ps.executeQuery();

        if(rs.next()){  //Esiste già un utente con quel nome
            popupScript ="<script> \n" +
                    "titolo_errore.innerText = \"21: Username: " + request.getParameter("username") + " gia utilizzato\" \n" +
                    "var form = document.getElementById(\"formSignUp\") \n" +
                    "form.appendChild(titolo_errore) \n" +
                    "let input = document.getElementById(\"idUsername\");\n" +
                    "input.setAttribute(\"error\",\"true\")\n" +
                    "let input_label = document.getElementById(\"idUsername_label\")\n" +
                    "input_label.setAttribute(\"error_label\",\"true\") \n" +
                    "document.getElementById(\"idName\").value=\"" + request.getParameter("name") + "\" \n" +
                    "document.getElementById(\"idSurname\").value=\"" + request.getParameter("surname") + "\" \n" +
                    "document.getElementById(\"idMail\").value=\"" + request.getParameter("mail") + "\" \n" +
                    "document.getElementById(\"idUsername\").value=\"" + request.getParameter("username") + "\" \n" +
                    "document.getElementById(\"idNumeroDiTelefono\").value=\"" + request.getParameter("phone_number") + "\" \n" +
                    "document.getElementById(\"idDataDiNascita\").value=\"" + request.getParameter("birth") + "\" \n" +
                    "document.getElementById(\"idPassword1\").value=\"" + request.getParameter("password") + "\" \n" +
                    "document.getElementById(\"idPassword2\").value=\"" + request.getParameter("password") + "\" \n" +
                    "</script>";
            response.setContentType("text/html");

            RequestDispatcher requestDispatcher;
            requestDispatcher=request.getRequestDispatcher("signUp.jsp");
            requestDispatcher.include(request, response);

            PrintWriter out = response.getWriter();
            out.println(popupScript);
        }
        else {
            query = "INSERT INTO LOGINTABLE VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";

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

                RequestDispatcher requestDispatcher;
                requestDispatcher=request.getRequestDispatcher("/registrazioneCofermata.jsp");
                requestDispatcher.forward(request, response);

            }
            else {
                popupScript = "<script> alert('21: Errore nella registrazione!'); window.location.href = 'signUp.jsp'; </script>";
            }
        }

    }

    public static void eliminaUtente(Connection conn, HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        PreparedStatement ps = null;
        String query;


        query = "DELETE FROM LOGINTABLE WHERE ID=?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        System.out.println("id = " + id);

        ps.executeUpdate();

        HttpSession session = request.getSession(false);            //controllo se ci sono gia sessioni esistenti, senza crearne di nuove
        session.invalidate();

        response.setContentType("text/plain");

    }

    public static void getAllUtenti(Connection conn, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String scelta = request.getParameter("categoriaCercata");
        String query;
        String query2;

        PreparedStatement ps;
        ResultSet rs;
        PreparedStatement ps2;
        ResultSet rs2;

        System.out.println("--------------------------Inizio----------------------");
        System.out.println("Dentro getUtentiServlet ,scelta = " + scelta);

        if(scelta.equals("aderente")||scelta.equals("simpatizzante")){    //Solo una categoria
            query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                    "FROM LOGINTABLE " +
                    "LEFT JOIN (" +
                    "   SELECT USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                    "   FROM DONATIONTABLE " +
                    "   GROUP BY USERNAME_DONATORE" +
                    ") AS D ON LOGINTABLE.USERNAME = D.USERNAME_DONATORE " +
                    "WHERE ROLE = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, scelta);
        }
        else{   //Entrambe le categorie
            //System.out.println("Scelte entrambe le categorie");
            query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                    "FROM LOGINTABLE " +
                    "LEFT JOIN (" +
                    "   SELECT USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                    "   FROM DONATIONTABLE " +
                    "   GROUP BY USERNAME_DONATORE" +
                    ") AS D ON LOGINTABLE.USERNAME = D.USERNAME_DONATORE ";
            ps = conn.prepareStatement(query);
        }

        rs = ps.executeQuery();

        StringBuilder jsonBuilder = new StringBuilder("[");

        boolean anotherOne = rs.next();

        while (anotherOne){

            query2 = "SELECT ATTIVITA FROM ISCRIZIONIATTIVITATABLE WHERE USERNAME_UTENTE = ?";
            ps2 = conn.prepareStatement(query2);
            ps2.setString(1, rs.getString("USERNAME"));
            rs2 = ps2.executeQuery();

            StringBuilder listaAttivita = new StringBuilder("[");
            boolean anotherOne2 = rs2.next();
            while (anotherOne2){
                System.out.println("Attivita trovata: " + rs2.getString("ATTIVITA"));
                listaAttivita.append(rs2.getString("ATTIVITA"));
                System.out.println("Ora la stringa è: " + listaAttivita);
                anotherOne2 = rs2.next();
                if(anotherOne2){
                    listaAttivita.append(" - ");
                }
            }
            listaAttivita.append("]");

            System.out.println("Elemento trovato, username = " + rs.getString("USERNAME"));
            jsonBuilder.append("{");
            jsonBuilder.append("\"ID\": \"").append(rs.getInt("ID")).append("\",");
            jsonBuilder.append("\"USERNAME\": \"").append(rs.getString("USERNAME")).append("\",");
            jsonBuilder.append("\"ROLE\": \"").append(rs.getString("ROLE")).append("\",");
            jsonBuilder.append("\"NAME\": \"").append(rs.getString("NAME")).append("\",");
            jsonBuilder.append("\"SURNAME\": \"").append(rs.getString("SURNAME")).append("\",");
            jsonBuilder.append("\"BIRTH\": \"").append(rs.getDate("BIRTH")).append("\",");
            jsonBuilder.append("\"MAIL\": \"").append(rs.getString("MAIL")).append("\",");
            jsonBuilder.append("\"PHONE_NUMBER\": \"").append(rs.getString("PHONE_NUMBER")).append("\",");
            jsonBuilder.append("\"LISTA_ATTIVITA\": \"").append(listaAttivita).append("\",");
            jsonBuilder.append("\"SUM_DONATION\": ").append(rs.getInt("SUMDONATION"));
            jsonBuilder.append("}");

            System.out.println("LISTA_ATTIVITA=" + listaAttivita);

            anotherOne = rs.next();
            if (anotherOne) {   //ce ne è ancora (almeno) uno
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        String json = jsonBuilder.toString();
        response.setContentType("application/json");
        response.getWriter().write(json);

    }


}
