package jdbc;

import java.sql.*;

public class Scrollable2
{
	public static void main(String[] args) throws SQLException
	{
		String url="jdbc:mysql://localhost:3307/test";
    	String username="root";
    	String password="12345";
    	
		try(Connection con=DriverManager.getConnection(url,username,password))
		{
			String sql= "select * from student";
			
			Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet result= st.executeQuery(sql);
			result.first();
			
			readStudentInfo("first:",result);
			
			result.relative(3);
			
			readStudentInfo("relative(3):",result);
			
			result.previous();
			
			readStudentInfo("previous:", result);
			
			result.absolute(4);
			
			readStudentInfo("Absolute(4):",result);
			
			result.last();
			
			readStudentInfo("Last:",result);
			
			result.relative(-1);
			
			readStudentInfo("Relative(-1):",result);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void readStudentInfo(String position, ResultSet result) throws SQLException {
		
		String id=result.getString("rollno");
		String name= result.getString("name");
		String studclass1=result.getString("class");
		// TODO Auto-generated method stub
		String StudInfo="%s:%s-%s-%s\n";
		System.out.format(StudInfo,position,id,name,studclass1);
	}

}
