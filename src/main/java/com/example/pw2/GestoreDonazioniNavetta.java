package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GestoreDonazioniNavette", value = "/GestoreDonazioniNavetta")
public class GestoreDonazioniNavetta extends HttpServlet {
    int donazioniNavetta = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
    }
}
