package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "GestoreDonazioniNavette", urlPatterns ={"/GestoreDonazioniNavetta"} )
public class GestoreDonazioniNavetta extends HttpServlet {

    Connection conn = connect.connectdb();
    DonazioniNavettaModel dn = new DonazioniNavettaModel();    //model per le donazioni navetta
    int donazioniNavetta;
    int obbiettivoDonazioni = 100000;

    @Override
    public void init() throws ServletException {
        super.init();

        // prendo dal DataBase le donazioni navette
        donazioniNavetta = dn.getDonazioniNavetta(conn);    //Salvo le donazioni presenti
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("GET "+ conn);
        donazioniNavetta = dn.getDonazioniNavetta(conn);    //Aggiorno le donazioni

        // elamborazione dati
        float perc = ((float)donazioniNavetta/obbiettivoDonazioni) *100;   // caloclo la percentuale
        float percDonazioni = (float) (Math.round(perc*100)/100.0);         // arrotondo la percentuale a 2 cifre dopo la virgola
        request.setAttribute("percDonazioni",percDonazioni);             // inserisco nella richiesta la percentuale calcolata

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

        // aumetno le donazioni totali
        //System.out.println(conn);
        //System.out.println("prima di post:"+donazioniNavetta);
        dn.setDonazioniNavetta(conn, improve);
        donazioniNavetta=dn.getDonazioniNavetta(conn);
        //System.out.println("dopo di post:"+donazioniNavetta);

        float perc = ((float)donazioniNavetta /obbiettivoDonazioni) *100;   // trovo la percentuale
        float percDonazioni = (float) (Math.round(perc*100)/100.0);         // arrotondo la percentuale
        request.setAttribute("percDonazioni",percDonazioni);

        RequestDispatcher requestDispatcher;
        requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy(){
        connect.closeConnection(conn);  //chiudo la connessione
        super.destroy();
    }
}
