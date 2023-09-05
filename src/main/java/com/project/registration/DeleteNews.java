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

@WebServlet("/DeleteNews")
public class DeleteNews extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int newsId = Integer.parseInt(request.getParameter("news_id"));
       
        try 
        {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
                    "gaurang@2271#");

            // Delete news
            String sqlDeleteNews = "DELETE FROM news_titles WHERE news_id=?";
            PreparedStatement stmtDeleteNews = conn.prepareStatement(sqlDeleteNews);
            stmtDeleteNews.setInt(1, newsId);
            stmtDeleteNews.executeUpdate();

          

            // Clean-up environment
            stmtDeleteNews.close();
            
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
            response.sendRedirect("admin.jsp");
        } 
        catch (Exception e) 
        {
            // Handle errors for Class.forName
            e.printStackTrace();
            // Set error attribute and redirect
            request.setAttribute("deleteError", true);
            response.sendRedirect("admin.jsp");
        }
    }
  }