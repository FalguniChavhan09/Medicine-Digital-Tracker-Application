package com.r3sys.medical;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connectdb.ConnectionD;

/**
 * Servlet implementation class AdminUser
 */
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String Aemail = request.getParameter("Aemail");
		String Apassword = request.getParameter("Apassword");
		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("select * from admin where Aemail=? and Apassword=?");
			p1.setString(1, Aemail);
			p1.setString(2, Apassword);
			ResultSet rs = p1.executeQuery();
			if
		    (rs.next())
			{
				response.sendRedirect("MDoption.html");
			}
			else
			{
				response.sendRedirect("admin.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
