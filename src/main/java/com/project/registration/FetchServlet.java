package com.project.registration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	
    	List<String> titles = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        List<String> url = new ArrayList<>();
        List<String>published = new ArrayList<>();
        List<String> categories = new ArrayList<>();
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","gaurang@2271#");

            // Execute SQL query
            String sql = "SELECT * FROM news_titles";
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            // Extract data from result set
            while (rs.next()) {
                titles.add(rs.getString("title"));
                descriptions.add(rs.getString("description"));
                categories.add(rs.getString("category"));
                url.add(rs.getString("url"));
                published.add(rs.getString("published"));
                ids.add(rs.getInt("news_id"));
                //session.setAttribute("ids", rs.getInt("news_id"));
                
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("titles", titles);
        session.setAttribute("descriptions", descriptions);
        session.setAttribute("url", url);
        session.setAttribute("published", published);
        session.setAttribute("categories", categories);
        session.setAttribute("ids", ids);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }
}

