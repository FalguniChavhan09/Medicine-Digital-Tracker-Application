package com.r3sys.medical;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.r3sys.Connectdb.ConnectionD;

/**
 * Servlet implementation class ClinicLog
 */
public class ClinicLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicLog() {
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
		
		String Cemail = request.getParameter("Cemail");
		String Cpassword = request.getParameter("Cpassword");
		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("select * from clinic_table where Cemail=? and Cpassword=?");
			p1.setString(1, Cemail);
			p1.setString(2, Cpassword);
			ResultSet rs = p1.executeQuery();
			if
		    (rs.next())
			{
				response.sendRedirect("index.html");
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
