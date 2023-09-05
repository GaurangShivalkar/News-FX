package com.project.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CommentFetchServlet")
public class CommentFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comments> comments = new ArrayList<>();     
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","gaurang@2271#");

            // Execute SQL query
            String sql = "SELECT * FROM comments ";
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
           
            while (rs.next()) {
            	   String comment = rs.getString("comment");
                   int parentId = rs.getInt("parent_id");
                   int userId = rs.getInt("user_id");
                   String userN = rs.getString("user_name");
                   int commentId = rs.getInt("comment_id");
                   Comments c = new Comments(comment, parentId, userId, userN, commentId);
                   comments.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("comme", comments);
       
        RequestDispatcher rd = request.getRequestDispatcher("csec.jsp");
        rd.forward(request, response);
        
	}
}
