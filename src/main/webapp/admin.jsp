<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<%@include file="navbar.jsp"%>
<style><%@include file="../css/admin.css"%></style>
</head>
<body class="home">
<div id="container">
	<h1>ADMIN PANEL</h1>
	<h3><a href="/NewsDiscussion/UserInfo">Users section</a></h3>
	<table border="1">
		<tr>
			<th>user name</th>
			<th>email</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="i" begin="0" end="3">
		<tr>
				<td>${Uname[i]}</td>
				<td>${Uemail[i]}</td>
				<td>
				<form action="DeleteUsers" method="get">
						<input type="hidden" name="users_id" value="${Uid[i]}">
						<button type="submit">Delete</button>
				</form>
				</td>
		</tr>
		</c:forEach>
	</table>
	<h3>News section</h3>
	<table border=1>
		<tr>
			<th>news id</th>
			<th>news title</th>
			<th>news description</th>
			<th>news category</th>
			<th>delete news</th>
			<th><a href="/NewsDiscussion/CommentFetchServlet">Comments</a></th>
		</tr>
		<c:forEach var="i" begin="0" end="${titles.size()-1}">
			<tr>
				<td>${ids[i]}</td>
				<td>${titles[i]}</td>
				<td>${descriptions[i]}</td>
				<td>${categories[i]}</td>
				<td>
					<form action="DeleteNews" method="get">
						<input type="hidden" name="news_id" value="${ids[i]}">
						<button type="submit">Delete</button>
					</form>
				</td>
				<td><c:forEach var="comment" items="${comme}">
						<c:if test="${comment['parentId'] == ids[i]}">
        				${comment.comment} [${comment.userN}] [${comment.commentId}]
	        				<form action="DeleteComment" method="post">
								<input type="hidden" name="comment_id"
									value="${comment.commentId}">
								<button type="submit">Delete</button>
							</form>

						</c:if>

					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
<script><%@include file="/Darkmode.js"%></script>
</html>