package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UtenteServlet", value = "/UtenteServlet")
public class UtenteServlet extends HttpServlet {

    Connection conn = connect.connectDb();
    ModelUtente mu = new ModelUtente();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            mu.getAllUtenti(conn,request,response);
        }catch (SQLException e) {
            System.out.println("(GetUtentiServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            mu.registraNuovoUtente(conn,request,response);
        } catch (SQLException e) {
            System.out.println("(SignUpServlet) Errore: " + e);
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            mu.eliminaUtente(conn,req,resp);
        } catch (SQLException e) {
            System.out.println("(EliminaAccountServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }


}
