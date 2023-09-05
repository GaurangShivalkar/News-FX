package com.project.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("comment_id"));
        try 
        {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
                    "gaurang@2271#");
			
			// Delete comments
	        String sqlDeleteComment = "DELETE FROM comments WHERE comment_id=?";
	        PreparedStatement stmtDeleteComment = conn.prepareStatement(sqlDeleteComment);
	        stmtDeleteComment.setInt(1, commentId);
	        stmtDeleteComment.executeUpdate();
	        
	        stmtDeleteComment.close();
	        conn.close();
	      
	        request.setAttribute("deleteSuccess", true);
	        response.sendRedirect("admin.jsp");
	    } 
	    catch (SQLException se) 
	    {
	        // Handle errors for JDBC
	        se.printStackTrace();
	        // Set error attribute and redirect
	        request.setAttribute("deleteError", true);
	        response.sendRedirect("admin.jsp");
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        //response.sendRedirect("/CommentFetchServlet");
	     // Dispatch to CommentFetchServlet
	        RequestDispatcher commentFetch = request.getRequestDispatcher("CommentFetchServlet");
	        commentFetch.forward(request, response);

	        // redirect to admin.jsp
	        RequestDispatcher adminPage = request.getRequestDispatcher("admin.jsp");
	        adminPage.forward(request, response);
	        
	    }
	}
}
