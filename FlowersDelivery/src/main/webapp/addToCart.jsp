<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add to cart</title>
</head>
<body>
<%@ page import="java.sql.*, java.util.Random"%>
<% int selectedID=0;
    
    try{ 
    	selectedID=Integer.parseInt(request.getParameter("p"));
    	
       }catch(NumberFormatException ex) { System.err.println("Ilegal input"); }

	try{
	
		Class.forName("org.postgresql.Driver");
   	
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useSSL=false","postgres","jklnm");
   		
		Statement st=con.createStatement();
		ResultSet rs;
		PreparedStatement ps;
   	
		Integer order_id;
   		
		if (session.getAttribute("order_id_key")==null) {
			order_id = new Random().ints(1, 100).findFirst().getAsInt();
			session.setAttribute("order_id_key", order_id);
		}
		order_id=(Integer)session.getAttribute("order_id_key");

		rs = st.executeQuery("select * from bouquet where bouquet_id='"+selectedID+"'");
		rs.next();
   					
		int bouquet_id=rs.getInt(1);
		String bouquet_name=rs.getString(2);
		int bouquet_price=rs.getInt(3);
   						
		session.setAttribute("bouquet_id_key", bouquet_id);
		session.setAttribute("bouquet_name_key", bouquet_name);
		session.setAttribute("bouquet_price_key", bouquet_price);
   			
		ps=con.prepareStatement("insert into \"order\"(order_id, bouquet_id, quantity, total_price)  values(?,?,?,?)");
   					
		int totalPrice=bouquet_price;
		ps.setInt(1, order_id);
		ps.setInt(2, bouquet_id);
		ps.setInt(3, 1);
		ps.setInt(4, totalPrice);
		ps.executeUpdate();

		response.sendRedirect("Welcome.jsp");

		Statement st2 = con.createStatement();
		ResultSet rs2 = st2.executeQuery("select count(*) as bouquetno from \"order\" where order_id='"+order_id+"'");
		rs2.next();
		int fno=rs2.getInt("bouquetno");
		int no_of_items=fno;
		session.setAttribute("no_of_items_key", no_of_items);
		con.close();
	}catch(Exception e){ 
		e.printStackTrace();
	}
   %>
</body>
</html>
