package com.example.pw2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "VisualizzaVisiteServlet", value = "/VisualizzaVisiteServlet")
public class VisualizzaVisiteServlet extends HttpServlet {

    int counterVisite = 0;
    private Map<String, Integer> mapPagineVisitate = new HashMap<>();       //Mi permette di associare ogni pagina al numero di visite che ha ricevuto

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Qualcuno ha visitato la pagina
        counterVisite++;


        //Cerco quale pagina è stata visitata
        String page = request.getRequestURI();

        //Incremento il numero di visite per la pagina attuale
        int countPagina = mapPagineVisitate.getOrDefault(page, 0);
        mapPagineVisitate.put(page, countPagina + 1);

        //Per la risposta
        JSONObject jsonData = new JSONObject();
        jsonData.put("nVisite", counterVisite);
        jsonData.put("pagineVisitate", getPagineVisitate());

        // Imposta l'intestazione della risposta come JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Scrivi il JSON come risposta
        response.getWriter().write(jsonData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private JSONArray getPagineVisitate() throws JSONException {
        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<String, Integer> entry : mapPagineVisitate.entrySet()) {
            JSONObject pageVisit = new JSONObject();
            pageVisit.put("pagina", entry.getKey());
            pageVisit.put("visita", entry.getValue());
            jsonArray.put(pageVisit);
        }

        return jsonArray;
    }
}
