
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
	<style><%@include file="../css/navbar.css"%></style>	
   <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


    <link rel="preconnect" href="https://fonts.googleapis.com">
  
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Merriweather:wght@300;400;700;900&family=Source+Sans+Pro:wght@200;300;400;600;700;900&display=swap" rel="stylesheet"> 
    
   	<script>
   		$(document).on('click', '#menu-tab', function () {
			$('#menu-nav').slideToggle('slow');
		});
   	</script> 

</head>
<body>

<!--TOP NAVIGATION-->
<header id="header">
	
	<div id="menu-wrapper">
   		<div id="menu-nav">
          <ul>
            <li><a href="/NewsDiscussion/FetchServlet">Refresh</a></li>
           
            <% if (session.getAttribute("isAdmin") != null && session.getAttribute("isAdmin").equals(1)) { %>
            	<li><a href="/NewsDiscussion/NewsDispServlet">update News</a></li>
    			<li><a href="admin.jsp">Admin</a></li>
			<% } %>

          </ul>
        </div>
       <div id="menu-tab" class="closed"><span id="menu"><i class="fa fa-navicon"></i></span></div>
    </div>  
   
    
    
    <div class="topnav" id="myTopnav">
	

        <a id="active" href="home.jsp">News Nexus</a>
        <a href="topHeadline.jsp">headline</a>
        <a href="sports.jsp">Sports</a>
        <a href="tech.jsp">Technology</a>
     	<a href="science.jsp">Science</a>
        <a href="ent.jsp">Entertainment</a>
        
       <!-- <div class="dropdown">
            <button class="dropbtn"> About
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content animate">
                <a href="#">Contact us</a>
                <a href="#">Feedback</a>
            </div>
        </div>  -->
        <input type="text" id="searchInput" onkeyup="searchNews()" placeholder="Search...">
		<label class="switch" style="float:right;padding: 15px 2px;">
        	<input type="checkbox">
        	<span class="slider round"></span>
        </label>
		
        <a href="sign.jsp" style="float:right;padding: 15px 2px;"><i class="fa fa-sign-out"></i></a>
        <a href="profile.jsp" style="float:right;padding: 15px 2px;"><i class="fa fa-user-circle-o"><br>${name}</i></a>
        
    </div>
</header>


</body>

</html>
