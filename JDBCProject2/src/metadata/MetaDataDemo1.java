package metadata;

import java.sql.*;

public class MetaDataDemo1 
{

	public static void main(String[] args)
	{
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			DatabaseMetaData dbmeta=con.getMetaData();
			
			System.out.println("DatabaseProductName: "+dbmeta.getDatabaseProductName());
			System.out.println("DatabaseProductVersion: "+dbmeta.getDatabaseProductVersion());
			System.out.println("DriverName: "+dbmeta.getDriverName());
			System.out.println("DriverVersion: "+dbmeta.getDriverVersion());
			System.out.println("URL: "+dbmeta.getURL());
			System.out.println("JDBCMajorVersion: "+dbmeta.getJDBCMajorVersion());
			System.out.println("UserName: "+dbmeta.getUserName());
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
	}

}
