package com.r3sys.Connectdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionD 
{
	public static Connection con=null;
	public static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicaltrackerapp","root","");
			if(con!=null)
			{
				System.out.println("Connection Established.....!!");
			}
			else
			{
				System.out.println("Failed connection.....!!");
			}
		}
		catch(Exception ae)
		{
			System.out.println("Connection Failed...!!");
		}
		return con;
		
	}
}
