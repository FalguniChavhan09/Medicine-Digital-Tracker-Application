package com.r3sys.medical;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connectdb.ConnectionD;

/**
 * Servlet implementation class Medicine
 */
public class Medicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Medicine() {
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
		
		String Medname = request.getParameter("Medname");
		String Medbrand = request.getParameter("Medbrand");
		String Medquantity = request.getParameter("Medquantity");
		String Medmanufacture = request.getParameter("Medmanufacture");
		String Medexpirey = request.getParameter("Medexpirey");		
		String agegroup = request.getParameter("agegroup");
		String Meddiscount = request.getParameter("Meddiscount");
		String Medprice = request.getParameter("Medprice");
		
		        String inputDateStr = Medexpirey; // Replace this with your input date from the form

		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate inputDate = LocalDate.parse(inputDateStr, formatter);
		        
		        // Subtract one month from the input date
		        LocalDate oneMonthBeforeDate = inputDate.minusMonths(1);

		        // Output the result in the same format as the input
		        String oneMonthBeforeDateStr = oneMonthBeforeDate.format(formatter);
		        System.out.println("One month before the input date: " + oneMonthBeforeDateStr);
		   		
		try
		{
			Connection con = ConnectionD.connect();
			PreparedStatement p1 = con.prepareStatement("insert into medicine_table values(?,?,?,?,?,?,?,?,?,?)");
			p1.setInt(1, 0);
			p1.setString(2, Medname);
			p1.setString(3, Medbrand);
			p1.setString(4, Medquantity);
			p1.setString(5, Medmanufacture);
			p1.setString(6, Medexpirey);
			p1.setString(7,oneMonthBeforeDateStr);
			p1.setString(8, agegroup);
			p1.setString(9, Meddiscount);
			p1.setString(10, Medprice);
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
