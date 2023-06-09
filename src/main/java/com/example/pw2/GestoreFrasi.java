package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GestoreFrasi", value = "/GestoreFrasi")
public class GestoreFrasi extends HttpServlet {

    Connection conn;
    String[] frasi;

    @Override
    public void init() throws ServletException {
        super.init();
        Connection conn = connect.connectdb();

        // Dovremmo prenderlo dal DB
        String[] frasi = {"Fare volontariato fa bene all’anima e al cuore. (Roy Disney)","Là dove c’è un volontario, c’è umanità e speranza. (Rinaldo Sidoli)", "Quello che per gli altri è perdita di tempo per me è vita. (Rinaldo Sidoli)", "Tutti noi abbiamo la responsabilità di essere volontari da qualche parte. (Jennifer Garner)"};

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GETSORE CHIAMAT0");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
