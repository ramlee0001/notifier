<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
<title>Welcome</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<link rel="stylesheet" href="notification.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
.icon {
    cursor: pointer;
    margin-right: 50px;
    line-height: 80px
}

.icon span {
    background: #f00;
    padding: 7px;
    border-radius: 50%;
    color: #fff;
    vertical-align: top;
    margin-left: -25px
}

.icon img {
    display: inline-block;
    width: 26px;
    margin-top: 4px
}

.icon:hover {
    opacity: .7
}

.logo {
    flex: 1;
    margin-left: 50px;
    color: #eee;
    font-size: 20px;
    font-family: monospace
}

.notifications {
    width: 300px;
    height: 0px;
    opacity: 0;
    position: absolute;
    top: 63px;
    right: 62px;
    border-radius: 5px 0px 5px 5px;
    background-color: #fff;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)
}

.notifications h2 {
    font-size: 14px;
    padding: 10px;
    border-bottom: 1px solid #eee;
    color: #999
}

.notifications h2 span {
    color: #f00
}

.notifications-item {
    display: flex;
    border-bottom: 1px solid #eee;
    padding: 6px 9px;
    margin-bottom: 0px;
    cursor: pointer
}

.notifications-item:hover {
    background-color: #eee
}

.notifications-item img {
    display: block;
    width: 50px;
    height: 50px;
    margin-right: 9px;
    border-radius: 50%;
    margin-top: 2px
}

.notifications-item .text h4 {
    color: #777;
    font-size: 16px;
    margin-top: 3px
}

.notifications-item .text p {
    color: #aaa;
    font-size: 12px
}
</style>
</head>
<body>
	<nav class="nav-wrapper black">
		<div class="container">
			<ul class="side-nav" id="slide-out">
				<li><a href="addnotes.jsp">Add Notes</a></li>
				<li><a href="edituser.jsp">Edit User</a></li>
			</ul>
			<ul class="right">
				<li>
				<div class="icon" id="bell"> <img src="https://i.imgur.com/AC7dgLA.png" alt=""> </div>
    			<div class="notifications" id="box">
        		<h2>Notifications - <span></span></h2>
        		<c:forEach var="tod" items="${sessionScope.today }">
        		<div class="notifications-item"> <img src="https://i.imgur.com/uIgDDDd.jpg" alt="img">
            	<div class="text">
                	<h4>${tod.title}</h4>
                	<p>${tod.desc}</p>
            	</div>
        		</div>
       </c:forEach>
    			</div></li>
				<li><a href="login.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
	<main>
		<h3 style="text-align: center;">Notes</h3>
		<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">S.NO</th>
      <th scope="col">TITLE</th>
      <th scope="col">DESCRIPTION</th>
      <th scope="col">DATE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${sessionScope.notes }">    
    <tr>
      <th scope="row">${list.no }</th>
      <td>${list.title }</td>
      <td>${list.desc }</td>
      <td>${list.date }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</main>
	<script src="https://kit.fontawesome.com/52bf741a29.js"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	<script>
            $(document).ready(function(){
			$(".notification_icon .fa-bell").click(function(){
				$(".dropdown").toggleClass("active");
			})
		});
        </script>
        <script>
        $(document).ready(function(){




        	var down = false;

        	$('#bell').click(function(e){

        	var color = $(this).text();
        	if(down){

        	$('#box').css('height','0px');
        	$('#box').css('opacity','0');
        	down = false;
        	}else{

        	$('#box').css('height','auto');
        	$('#box').css('opacity','1');
        	down = true;

        	}

        	});

        	});
        </script>
        
</body>
</html>