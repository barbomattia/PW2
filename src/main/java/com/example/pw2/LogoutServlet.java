package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        // Rimuovo i cookie per il form ricontattami
        if(checkCookiesAllowed(request)){
            Cookie nome_cognome = new Cookie("nome_cognome","");
            Cookie mail = new Cookie("mail", "");
            nome_cognome.setMaxAge(0);   // stessa età della sessione
            mail.setMaxAge(0);
            response.addCookie(nome_cognome);
            response.addCookie(mail);
        }

        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    boolean checkCookiesAllowed(HttpServletRequest request){

        boolean consenso = false;

        Cookie[] cookies = request.getCookies();
        for ( int i=0; i<cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("cookieAllow")) {
                if( cookie.getValue().equals("true") ){
                    consenso=true;
                }
            }
        }

        return consenso;
    }
}
