package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AccettazioneCookies", value = "/AccettazioneCookies")
public class AccettazioneCookies extends HttpServlet {

    // QUESTA SERVLET NON SERVE A NIENTE MA LASCIATELA CHE PUç TORNARE UTILE

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            System.out.print("Name : " + cookie.getName( ) + ",  ");
            System.out.print("Value: " + cookie.getValue( ) + " <br/>");
        }

        Cookie prova = new Cookie("prova", "prova");


        response.addCookie(prova);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
