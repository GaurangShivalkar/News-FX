package com.project.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String upwd = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root","gaurang@2271#");
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? and upwd = ? ");
			
			pst.setString(1, email);
			pst.setString(2, upwd);
			HttpSession session = request.getSession();
			
			RequestDispatcher dispatcher = null;
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("name", rs.getString("uname"));
				session.setAttribute("user_id", rs.getInt("user_id"));
				session.setAttribute("isAdmin", rs.getInt("isAdmin"));// added this line to send user_id to output
				if(rs.getInt("isAdmin") == 1) 
				{ // check if user is an admin
					dispatcher = request.getRequestDispatcher("admin.jsp"); // redirect to admin.jsp
				} 
				else 
				{
					dispatcher = request.getRequestDispatcher("home.jsp");
				}
			}
			else 
			{
				request.setAttribute("status" , "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
