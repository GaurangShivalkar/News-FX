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

@WebServlet("/DeleteUsers")
public class DeleteUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int UserId = Integer.parseInt(request.getParameter("users_id"));
	       
	        try 
	        {
	            // Register JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Open a connection
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "gaurang@2271#");

	            // Delete news
	            String sqlDeleteUser = "DELETE FROM users WHERE user_id=?";
	            PreparedStatement stmtDeleteUser = conn.prepareStatement(sqlDeleteUser);
	            stmtDeleteUser.setInt(1, UserId);
	            stmtDeleteUser.executeUpdate();

	          

	            // Clean-up environment
	            stmtDeleteUser.close();
	            
	            conn.close();
	            // Set success attribute and redirect
	            request.setAttribute("deleteSuccess", true);
	            response.sendRedirect("admin.jsp");
	        } 
	        catch (SQLException se) 
	        {
	            // Handle errors for JDBC
	            se.printStackTrace();
	            // Set error attribute and redirect
	            request.setAttribute("deleteError", true);
	            response.sendRedirect("home.jsp");
	        } 
	        catch (Exception e) 
	        {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	            // Set error attribute and redirect
	            request.getRequestDispatcher("UserInfo").forward(request, response);


		        response.sendRedirect("admin.jsp");
	        }
		
	}

	

}
