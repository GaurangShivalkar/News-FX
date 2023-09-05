<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="navbar.jsp"%>
<style><%@include file="../css/csec.css"%></style>
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<body class="home">
<div class="container">
	<c:forEach var="i" begin="0" end="${titles.size()-1}">
	<c:if test="${param.id == ids.get(i)}"> <!-- Check if the news article ID matches the clicked comment link -->
	
		<div class="main" >
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
                <form action="CommentStoreServlet" method="post">
					<textarea name="reply"></textarea>
					<input type="hidden" name="user_id" value="${user_id}">
					<input type="hidden" name="newd_id" value="${ids.get(i)}">
					<input type="hidden" name="user_name" value="${name}">
					
            		<input type="submit" value="Submit">
        		</form>
                <hr>
            
            <div class="view">
                <c:forEach var="comment" items="${comme}">
    				<c:if test="${comment['parentId'] == ids[i]}">
    					<i>posted by  ${comment.userN}</i>
        				<p>${comment.comment}</p>
    				</c:if>	
        			
				</c:forEach>
            </div>
				
			</div>
		</div>
	</div>
	</c:if>
	 </c:forEach>	
	 </div>

</body>
<script><%@include file="/like.js"%></script>

<script><%@include file="/Darkmode.js"%></script>
</html>