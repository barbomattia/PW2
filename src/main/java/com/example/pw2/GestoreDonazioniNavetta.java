package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GestoreDonazioniNavette", urlPatterns ={"/GestoreDonazioniNavetta"} )
public class GestoreDonazioniNavetta extends HttpServlet {

    // questi dati dovrebbero essere salvati nel database.
    int donazioniNavetta = 1000;
    int obbiettivoDonazioni = 100000;

    // implementazione init() per prendere i valori delle 2 variabili dal server.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // elamborazione dati
        float perc = ((float)donazioniNavetta /obbiettivoDonazioni) *100;
        float percDonazioni = (float) (Math.round(perc*100)/100.0);
        request.setAttribute("percDonazioni",percDonazioni);
        System.out.println(request.getAttribute("percDonazioni"));

        // chiama il file JSP per la parte view
        try{
            RequestDispatcher requestDispatcher;
            requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
            requestDispatcher.forward(request, response);
        }
        catch( Exception ex){
            System.out.println("Error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int improve = Integer.valueOf(request.getParameter("importo"));
        System.out.println("improve: " + improve);

        donazioniNavetta = donazioniNavetta + improve; // aumetno le donazioni totali

        float perc = ((float)donazioniNavetta /obbiettivoDonazioni) *100; // trovo la percentuale
        float percDonazioni = (float) (Math.round(perc*100)/100.0); // arrotondo la percentuale
        request.setAttribute("percDonazioni",percDonazioni);
        System.out.println(request.getAttribute("percDonazioni"));


        RequestDispatcher requestDispatcher;
        requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
        requestDispatcher.forward(request, response);

    }
}
