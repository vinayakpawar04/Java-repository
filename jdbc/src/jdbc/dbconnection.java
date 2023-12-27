package jdbc;

import java.sql.*;

public class dbconnection {
	
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3307/test1";
    	String username="root";
    	String password="12345";
		try
		{
			Connection  con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
}
