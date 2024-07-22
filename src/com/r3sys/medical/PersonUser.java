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
 * Servlet implementation class PersonUser
 */
public class PersonUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonUser() {
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
		
		String Uname = request.getParameter("Uname");
		String Uemail = request.getParameter("Uemail");
		String Upassword = request.getParameter("Upassword");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String Ucontact = request.getParameter("Ucontact");
		String Upincode = request.getParameter("Upincode");
		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("insert into normal_user values(?,?,?,?,?,?,?,?)");
			p1.setInt(1, 0);
			p1.setString(2, Uname);
			p1.setString(3, Uemail);
			p1.setString(4, Upassword);
			p1.setString(5, lat);
			p1.setString(6, lng);
			p1.setString(7, Ucontact);
			p1.setString(8, Upincode);
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
