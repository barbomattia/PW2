package com.example.pw2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ModelCookies {

    // SE NON viene trovato il cookieAllow o se è settato false ritorno false
    static public boolean checkCookiesAllowed(HttpServletRequest request){

        boolean consenso = false;

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for ( int i=0; i<cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("cookieAllow")) {
                    if( cookie.getValue().equals("true") ){
                        consenso=true;
                    }
                }
            }
        }

        return consenso;
    }


}
