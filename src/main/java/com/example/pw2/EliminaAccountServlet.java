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

@WebServlet(name = "EliminaAccountServlet", value = "/eliminaAccount")
public class EliminaAccountServlet extends HttpServlet {

    Connection conn = connect.connectdb();
    PreparedStatement ps = null;

    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String popupScript;

            query = "DELETE FROM DONATIONTABLE WHERE ID_DONATORE=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.valueOf(request.getParameter("id")));
            if(ps.executeUpdate() > 0){     //Eliminato tutti i dati dalla tabella donazioni
                query = "DELETE FROM loginTable WHERE id=?";

                ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.valueOf(request.getParameter("id")));
                if(ps.execute()){
                    //Account eliminato
                    popupScript = "<script> alert('21: Account eliminato con successo'); window.location.href = 'login.jsp'; </script>";
                }
                else {
                    //Errore nell'eleiminazione dell'account
                    popupScript = "<script> alert('21: Errore nell'eliminazione dell'account'); window.location.href = 'login.jsp'; </script>";
                }
            }
            else {
                //Altro tipo di errore
                popupScript = "<script> alert('21: Errore nell'eliminazione dell'account'); window.location.href = 'login.jsp'; </script>";
            }

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println(popupScript);

        } catch (SQLException e) {
            System.out.println("(EliminaAccountServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }
}
