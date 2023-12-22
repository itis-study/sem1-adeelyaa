<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="cart.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<style>
  .subhead-text{
    color: rgb(67, 202, 232);
    font-family: Lobster;
    font-size: 70px;}
</style>

   <link rel="stylesheet" href="CSS/style.css">
<style>
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }

     .jumbotron {
      margin-bottom: 0;
    }

    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>

<body>
<script src='https://cdn.rawgit.com/Siddharth11/gradStop.js/master/gradstop.js'></script>
    <script  src="CSS/index.js"></script>
<div class="background">
 

<div class="jumbotron">
  <div class="container text-center">
    <div class="subhead-text"> CART</div>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="Welcome.jsp"><button class="btn btn-warning"><i class="fa fa-angle-left"> Continue Shopping</i></button></a></li>
       
      </ul> 
     
 
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	 <li><a href="Checkout.jsp"><button class="btn btn-success btn-block"><i class="fa fa-angle-right">Checkout </i></button></a></li>
      	<li><a href="logout.jsp"><h4><span class="glyphicon glyphicon-user"></span> Log Out</h4></a></li> 

      	
      </ul>
    </div>
  </div>
</nav> 

	<%@ page import="java.sql.*"%>
	<div class="container">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Product</th>
					<th style="width: 10%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>

			<%	try{
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useSSL=false", "postgres", "jklnm");
				Statement st2 = con.createStatement();
				ResultSet rs2;
				int order_id_key = (Integer) session.getAttribute("order_id_key");
				rs2=st2.executeQuery("select bouquet.bouquet_id, bouquet.bouquet_name, bouquet.bouquet_price from bouquet, \"order\" where \"order\".order_id="+order_id_key+" and bouquet.bouquet_id=\"order\".bouquet_id");
				int total=0, totalFp=0, totalDp=0;
				while(rs2.next()){
				totalDp+=rs2.getInt(3); %>
			<tr>
				<td data-th="Product">
					<div class="row">
						<div class="col-sm-10">
							<h4 class="nomargin">
								<%=rs2.getString(2)%></h4>
						</div>
					</div>
				</td>
				<td data-th="Price"><%=rs2.getInt(3)%></td>
				<td data-th="Quantity">1</td>
				<td data-th="Subtotal" class="text-center"><%=rs2.getInt(3)%></td>
				
			</tr>
			 <%}
				con.close();
				total=totalFp+totalDp;	
				session.setAttribute("total_bill", total);
			%> 
			<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total <%=total%></strong></td>
						</tr>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total is: <%=total%></strong></td>
							<td colspan="2" class="hidden-xs"></td>
						</tr>
					</tfoot>
					<%}catch(Exception e){ e.printStackTrace();}	 %>
		</table>
		
	</div>

</body>
</html>



 
