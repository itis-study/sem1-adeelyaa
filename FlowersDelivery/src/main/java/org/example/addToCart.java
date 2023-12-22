package org.example;

import java.sql.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int Order_idCounter = 1;
    public static synchronized int Order_createID() {
        return Order_idCounter++;
    }
    public addToCart() { super(); }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int selectedID=0;
        try{
            selectedID = Integer.parseInt(request.getParameter("p"));
        } catch(NumberFormatException ex){
            System.err.println("Ilegal input");
        }

        try{

            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useSSL=false","postgres","jklnm");
            Statement st=con.createStatement();
            ResultSet rs;
            PreparedStatement ps;
            rs=st.executeQuery("select * from bouquet where bouquet_id='"+selectedID+"'");
            rs.next();
            int bouquet_id=rs.getInt(1);
            String bouquet_name=rs.getString(2);
            int bouquet_price=rs.getInt(3);
            HttpSession session=request.getSession();
            session.setAttribute("bouquet_id", bouquet_id);
            session.setAttribute("bouquet_name", bouquet_name);
            session.setAttribute("bouquet_price", bouquet_price);

            ps=con.prepareStatement("insert into order values(?,?,?,?)");
            int order_id=Order_createID();
            session.setAttribute("order_id", order_id);
            int totalPrice=bouquet_price;

            ps.setInt(1, order_id);
            ps.setInt(2, bouquet_id);
            ps.setInt(3, 1);
            ps.setInt(4, totalPrice);

            ps.executeUpdate();
            request.getRequestDispatcher("Welcome.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
