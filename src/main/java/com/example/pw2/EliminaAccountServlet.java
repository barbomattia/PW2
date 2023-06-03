package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "EliminaAccountServlet", value = "/eliminaAccount")
public class EliminaAccountServlet extends HttpServlet {

    Connection conn = connect.connectdb();
    PreparedStatement ps = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String query = "DELETE FROM loginTable WHERE id=?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.valueOf(request.getParameter("id")));
            if(ps.executeUpdate() > 0){
                //Account eliminato
                response.sendRedirect("login.jsp");
            }
            else {
                //Errore nell'eleiminazione dell'account
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>Errore</title></head>");
                out.println("<body>");
                out.println("<h1>Si è verificato un errore!</h1>");
                out.println("<p>Errore nell'eliminazione dell'account...</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
