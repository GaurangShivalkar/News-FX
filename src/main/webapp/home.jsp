<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>

<%if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="refresh" content="30">
	<title>Home page</title>
	<%@include file="navbar.jsp"%>
	<style><%@include file="../css/layout.css"%></style>
	<script>
		function searchNews() {
			var input, filter, main, desc, title, i, txtValue;
			input = document.getElementById("searchInput");
			filter = input.value.toUpperCase();
			main = document.getElementsByClassName("main");
			for (i = 0; i < main.length; i++) {
				title = main[i].getElementsByTagName("h2")[0];
				desc = main[i].getElementsByClassName("description")[0];
				
				if (desc || title) {
					txtValue = (desc ? desc.textContent || desc.innerText : '') + (title ? title.textContent || title.innerText : '');
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						main[i].style.display = "";
					} else {
						main[i].style.display = "none";
					}
				}
			}
		}
	</script>
	</head>
<body class="home">



	<c:forEach var="i" begin="0" end="${titles.size()-1}">
		<c:set var="index" value="${status.index}" />
		
			<div class="main" style="top:${index*30}%;">
				<c:set var="likeCount" value="${not empty cookie.likes[ids[i]] ? cookie.likes[ids[i]] : 0}" />
				<c:set var="dislikeCount" value="${not empty cookie.dislikes[ids[i]] ? cookie.dislikes[ids[i]] : 0}" />
				
				<div class="left">
				  <button class="like-btn ${likes[id] ? 'disabled' : ''}" data-id="${ids[i]}"><i class="fa fa-arrow-up"></i> <br><span>${likeCount}</span></button>
				  <button class="dislike-btn ${likes[id] ? 'disabled' : ''}" data-id="${ids[i]}"><i class="fa fa-arrow-down"></i> <br><span>${dislikeCount}</span></button>
								
				</div>
				
				<div class="right">
					<div class="top">				
						<i class="published">${published[i]}</i>
						<hr>
					
						<h2 ><a href="${url[i]}">${titles[i]}</a></h2><br>
						<p class="description">${descriptions[i]}</p><br><br>
						<p>${categories[i]}</p><br>
					</div>
					<div class="bottom">
						<label class="comm"><a href="/NewsDiscussion/CommentFetchServlet?id=${ids[i]}">Comments</a></label>
						
					</div>
				</div>
			</div>
		
	</c:forEach>

	
<script><%@include file="/like.js"%></script>

<script><%@include file="/Darkmode.js"%></script>

</body>
</html>








