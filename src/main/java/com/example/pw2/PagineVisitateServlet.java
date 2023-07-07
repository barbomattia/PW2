package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "PagineVisitateServlet", value = "/PagineVisitateServlet")
public class PagineVisitateServlet extends HttpServlet {

    PreparedStatement ps, ps2;
    ResultSet rs, rs2;
    Connection conn = connect.connectdb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomePagina = request.getParameter("nomePagina");

        String query = "SELECT * FROM COUNTERPAGETABLE WHERE NOME_PAGINA=?";
        String query2;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nomePagina);
            rs = ps.executeQuery();


            if(rs.next()){   //Se la pagina è già presente nel db
                query2 = "UPDATE COUNTERPAGETABLE SET COUNTER = COUNTER + 1 WHERE NOME_PAGINA = ?";

            }
            else {          //Inserisco la pagina nel db
                query2 = "INSERT INTO COUNTERPAGETABLE VALUES (?, 1)";
            }

            ps2 = conn.prepareStatement(query2);
            ps2.setString(1, nomePagina);
            ps2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("(PagineVisitateServlet) Errore: " + e);
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
