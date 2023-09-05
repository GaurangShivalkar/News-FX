/*package com.project.registration;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/NewsDispServlet")
public class NewsDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String[] titles = NewsApi.getNewsTitles();
		 Set<String> existingTitles = new HashSet<>();
	        try {
	            // Register JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Open a connection
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","gaurang@2271#");

	            // retrieve existing titles from database
	            String sql = "SELECT title FROM news_titles";
	            Statement statement = conn.createStatement();
	            ResultSet result = statement.executeQuery(sql);
	            while(result.next()) {
	                existingTitles.add(result.getString("title"));
	            }
	            
	            
	            // Execute SQL query
	            sql = "INSERT INTO news_titles (title) VALUES (?)";
	            PreparedStatement preparedStmt = conn.prepareStatement(sql);
	            for (String title : titles) {
	            	if (!existingTitles.contains(title)) {
		                preparedStmt.setString(1, title);
		                preparedStmt.execute();
	            	}
	            }

	            // Clean-up environment
	            result.close();
	            statement.close();
	            preparedStmt.close();
	            conn.close();
	            
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        }
	        request.setAttribute("titles", Arrays.asList(titles));
	        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	        dispatcher.forward(request, response);
	    }*/
	
	package com.project.registration;

import java.io.IOException;
import java.sql.*;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewsDispServlet")
public class NewsDispServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[][] news = NewsApi.getNews();
        Set<String> existingTitles = new HashSet<>();
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "gaurang@2271#");

            // retrieve existing titles from database
            String sql = "SELECT title FROM news_titles";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                existingTitles.add(result.getString("title"));
            }

            // Execute SQL query
            sql = "INSERT INTO news_titles (title, description, category, url, published) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            for (int i = 0; i < news.length; i++) {
                for (int j = 0; j < news[i].length; j++) {
                    String[] parts = news[i][j].split(" -/ ");
                    String title = parts[0];
                    String description = parts[1];
                    String url = parts[2];
                    String published = parts[3];
                    String category = "";
                    if (i == 0) {
                        category = "top-headlines";
                    } else if (i == 1) {
                        category = "sports";
                    } else if (i == 2) {
                        category = "technology";
                    } else if (i == 3) {
                        category = "science";
                    } else if (i == 4) {
                        category = "entertainment";
                    }
                    if (!existingTitles.contains(title)) {
                        preparedStmt.setString(1, title);
                        preparedStmt.setString(2, description);
                    
                        preparedStmt.setString(3, category);
                        preparedStmt.setString(4, url);
                        preparedStmt.setString(5, published);
                        preparedStmt.execute();
                    }
                }
            }

            // Clean-up environment
            result.close();
            statement.close();
            preparedStmt.close();
            conn.close();

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        request.setAttribute("news", news);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
