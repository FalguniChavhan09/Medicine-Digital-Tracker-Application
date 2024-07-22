<%@page import="com.r3sys.Connectdb.*" %>
<%@page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	try
	{
		String Mid = request.getParameter("Mid");
		Connection con = ConnectionD.connect();
		PreparedStatement p1 = con.prepareStatement("delete from medical_table where Mid=?");
		p1.setString(1, Mid);
		int i = p1.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("index.html");
		}
		else
		{
			response.sendRedirect("MDoption.html");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</body>
</html>