package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollLable1 {


     public static void main(String [] args)
     {
    	String url="jdbc:mysql://localhost:3307/test1";
    	String username="root";
    	String password="12345";
    	
    	try(Connection con=DriverManager.getConnection(url,username,password))
    	{
    		String sql="SELECT * FROM emp";
    		Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    		
    		ResultSet result= statement.executeQuery(sql);
    		
    		result.first();
    		
    		readEmpInfo("first",result);
    		
    		result.relative(2);
    		
    		readEmpInfo("relative(2)",result);
    		
    		result.previous();
    		readEmpInfo("previous",result);
    		
    		result.absolute(4);
    		readEmpInfo("absolute(4)",result);
    		    
    		result.last();
    		readEmpInfo("last",result);
    		
    		result.relative(-1);
    		readEmpInfo("relative(-1)",result);
    	
    	}
    	catch(SQLException ex)
    	{
    		ex.printStackTrace();
    	}
     }
     

	private static void readEmpInfo(String position, ResultSet result) throws SQLException
	{
		String id= result.getString("id");
		String name=result.getString("name");
		
		String empInfo="%s:%s-%s\n";
		
		System.out.format(empInfo,position,id,name);
	}
}