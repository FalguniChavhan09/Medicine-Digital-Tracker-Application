package com.r3sys.medical;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connectdb.ConnectionD;

/**
 * Servlet implementation class ClinicUser
 */
public class ClinicUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicUser() {
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
		
		String Cname = request.getParameter("Cname");
		String Cemail = request.getParameter("Cemail");
		String Cpassword = request.getParameter("Cpassword");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String Ccontact = request.getParameter("Ccontact");
		String Cpincode = request.getParameter("Cpincode");
		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("insert into clinic_table values(?,?,?,?,?,?,?,?)");
			p1.setInt(1, 0);
			p1.setString(2, Cname);
			p1.setString(3, Cemail);
			p1.setString(4, Cpassword);
			p1.setString(5, lat);
			p1.setString(6, lng);
			p1.setString(7, Ccontact);
			p1.setString(8, Cpincode);
			int i = p1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
