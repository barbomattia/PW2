package com.example.pw2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterCheckLogin")
public class FilterCheckLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;     // converto la richiesta in HttpServletRequest
        HttpServletResponse httpResponse = (HttpServletResponse) response;     // converto la richiesta in HttpServletRequest
        HttpSession session = httpRequest.getSession(false);            //controllo se ci sono gia sessioni esistenti, senza crearne di nuove

        boolean isLoggedIn = false;

        if(session != null ){
            isLoggedIn= ( session.getAttribute("logged") != null);
        }else{
            isLoggedIn = false;
        }

        if(isLoggedIn){
            //System.out.println(session.getAttribute("role").toString());
            if(session.getAttribute("role").toString().equals("amministratore")){
                httpResponse.sendRedirect("amministratore.jsp");
            } else {
                httpResponse.sendRedirect("simpOrAd.jsp");
            }
        }else{
            chain.doFilter(request,response);
        }


    }
}
