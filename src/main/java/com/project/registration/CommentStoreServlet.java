package com.project.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentStoreServlet")
public class CommentStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","gaurang@2271#");
			
			String reply = request.getParameter("reply");
			Integer userId = (Integer) request.getSession().getAttribute("user_id");
			String user_name = request.getParameter("user_name");
			String sql = "INSERT INTO comments (comment, user_id, parent_id, user_name) VALUES (?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, reply);
		    stmt.setInt(2, userId);
		    int newsId = Integer.parseInt(request.getParameter("newd_id"));
		 
		    stmt.setInt(3, newsId);
		    stmt.setString(4, user_name);
		    stmt.executeUpdate();

		
		}  catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
			} 
		
		response.setHeader("Location", "/NewsDiscussion/CommentFetchServlet?id=" + request.getParameter("newd_id"));
		response.setStatus(302); // set status code 302 for redirection

	     //RequestDispatcher rd = request.getRequestDispatcher("CommentFetchServlet");
	       // rd.forward(request, response);

	}

}
