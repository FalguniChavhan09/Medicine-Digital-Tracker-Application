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
 * Servlet implementation class MedicalUser
 */
public class MedicalUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalUser() {
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
		
		String Mname = request.getParameter("Mname");
		String Memail = request.getParameter("Memail");
		String Mpassword = request.getParameter("Mpassword");
		String Mcontact = request.getParameter("Mcontact");
		String Mlicenceno = request.getParameter("Mlicenceno");
		String Mlocation = request.getParameter("Mlocation");
		String Mpincode = request.getParameter("Mpincode");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("insert into medical_table values(?,?,?,?,?,?,?,?,?,?,?)");
			p1.setInt(1, 0);
			p1.setString(2, Mname);
			p1.setString(3, Memail);
			p1.setString(4, Mpassword);
			p1.setString(5, Mcontact);
			p1.setString(6, Mlicenceno);
			p1.setString(7, Mlocation);
			p1.setString(8, "pending");
			p1.setString(9, Mpincode);
			p1.setString(10, lat);
			p1.setString(11, lng);
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
