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

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Integer> uid = new ArrayList<>();
        List<String> uname = new ArrayList<>();
        List<String> uemail = new ArrayList<>();
    	try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","gaurang@2271#");

            // Execute SQL query
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
           
            while (rs.next()) {
            		uname.add(rs.getString("uname"));
            		uemail.add(rs.getString("email"));
            		uid.add(rs.getInt("user_id"));
;
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
         session.setAttribute("Uname", uname);
         session.setAttribute("Uemail", uemail);
         session.setAttribute("Uid", uid);
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);
    }

}
