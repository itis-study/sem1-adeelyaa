package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String emailID, password;

    public loginCheck() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        emailID = request.getParameter("email");
        password = request.getParameter("password");

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useSSL=false", "postgres", "jklnm");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer where customer_emailID = '" + emailID + "'");
            while (rs.next()) {
                if ((rs.getString(4)).equals(password)) {
                    RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("loginError.html");
                    rd.include(request, response);
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
