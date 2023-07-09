package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "EliminaAccountServlet", value = "/eliminaAccount")
public class EliminaAccountServlet extends HttpServlet {

    Connection conn = connect.connectDb();
    PreparedStatement ps = null;

    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String popupScript;
            int id = Integer.parseInt(request.getParameter("id"));

            query = "DELETE FROM DONATIONTABLE WHERE ID_DONATORE=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            System.out.println("id = " + id);

            if(ps.executeUpdate() >= 0){     //Eliminato tutti i dati dalla tabella donazioni
                query = "DELETE FROM loginTable WHERE id=?";

                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                if(ps.executeUpdate()>=0){
                    //Account eliminato
                    response.setHeader("message", "Account eliminato correttamente");
                    response.setStatus(HttpServletResponse.SC_OK);
                }
                else {
                    //Errore nell'eliminazione dell'account
                    response.setHeader("message", "Errore, impossibile eliminare l'account");
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
            else {
                response.setHeader("message", "Errore, impossibile eliminare l'account");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            HttpSession session = request.getSession(false);            //controllo se ci sono gia sessioni esistenti, senza crearne di nuove
            session.invalidate();

            response.setContentType("text/plain");

        } catch (SQLException e) {
            System.out.println("(EliminaAccountServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }
}
