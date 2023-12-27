package IO;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreImage {
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3307/test";
		String user="root";
		String password="12345";
		
		String filepath="C:\\Users\\HP\\Downloads\\rohit.png";
		
		try {
			Connection con= DriverManager.getConnection(url,user,password);
			String sql="INSERT INTO img(name,image) VALUE(?,?)";
			PreparedStatement statement= con.prepareStatement(sql);
			statement.setString(1,"Rohit");
			
			InputStream inputstream=new FileInputStream(new File(filepath));
			statement.setBlob(2, inputstream);
			
			int row = statement.executeUpdate();
			
			if(row>0)
			{
				System.out.println("The image is inserted.");
			}
			
		con.close();
			
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();	
		}
	}

}
