package com.example.pw2;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetUtentiServlet", value = "/GetUtentiServlet")
public class GetUtentiServlet extends HttpServlet {

    String query;
    PreparedStatement ps;
    ResultSet rs;
    Connection conn = connect.connectdb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("categoriaCercata");

        System.out.println("--------------------------Inizio----------------------");
        System.out.println("Dentro getUtentiServlet ,scelta = " + scelta);

        try {

            if(scelta.equals("simpatizzante") || scelta.equals("aderente")){    //Solo una categoria
                System.out.println("Scelto una categoria");
                query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                        "FROM LOGINTABLE " +
                        "LEFT JOIN (" +
                        "   SELECT ID_DONATORE, USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                        "   FROM DONATIONTABLE " +
                        "   GROUP BY ID_DONATORE, USERNAME_DONATORE" +
                        ") AS D ON LOGINTABLE.ID = D.ID_DONATORE AND LOGINTABLE.USERNAME = D.USERNAME_DONATORE " +
                        "WHERE ROLE = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, scelta);
                System.out.println("PS=" + ps);
            }
            else{   //Entrambe le categorie
                System.out.println("Scelte entrambe le categorie");
                query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                        "FROM LOGINTABLE " +
                        "LEFT JOIN (" +
                        "   SELECT ID_DONATORE, USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                        "   FROM DONATIONTABLE " +
                        "   GROUP BY ID_DONATORE, USERNAME_DONATORE" +
                        ") AS D ON LOGINTABLE.ID = D.ID_DONATORE AND LOGINTABLE.USERNAME = D.USERNAME_DONATORE ";
                ps = conn.prepareStatement(query);
            }

            rs = ps.executeQuery();

            StringBuilder jsonBuilder = new StringBuilder("[");

            boolean anotherOne = rs.next();

            while (anotherOne){
                System.out.println("Elemento trovato, username = " + rs.getString("USERNAME"));
                jsonBuilder.append("{");
                jsonBuilder.append("\"ID\": \"" + rs.getInt("ID") + "\",");
                jsonBuilder.append("\"USERNAME\": \"" + rs.getString("USERNAME") + "\",");
                jsonBuilder.append("\"ROLE\": \"" + rs.getString("ROLE") + "\",");
                jsonBuilder.append("\"NAME\": \"" + rs.getString("NAME") + "\",");
                jsonBuilder.append("\"SURNAME\": \"" + rs.getString("SURNAME") + "\",");
                jsonBuilder.append("\"BIRTH\": \"" + rs.getDate("BIRTH") + "\",");
                jsonBuilder.append("\"MAIL\": \"" + rs.getString("MAIL") + "\",");
                jsonBuilder.append("\"PHONE_NUMBER\": \"" + rs.getString("PHONE_NUMBER") + "\",");
                jsonBuilder.append("\"SUM_DONATION\": " + rs.getInt("SUMDONATION"));
                jsonBuilder.append("}");

                anotherOne = rs.next();
                if (anotherOne) {   //ce ne è ancora (almeno) uno
                    jsonBuilder.append(",");
                }
            }
            jsonBuilder.append("]");
            String json = jsonBuilder.toString();
            response.setContentType("application/json");
            response.getWriter().write(json);


        } catch (SQLException e) {
            System.out.println("(GetUtentiServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
