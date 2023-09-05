<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="id" items="${ids}">
    <p>${id}</p>
</c:forEach>

<table>
    <tr>
        <th>News Title</th>
    </tr>
    <c:forEach var="title" items="${titles}">
        <tr>
            <td>${title} </td>
            
        </tr>
          <td>
                <form action="CommentStoreServlet" method="post">
                	 <input type="hidden" name="news_id" value="${id}">
                    <textarea name="reply"></textarea>
                    <input type="submit" value="Submit">
                </form>
            </td>
    </c:forEach>
  </table>
</body>
</html>