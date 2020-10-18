package metadata;

import java.sql.*;
import java.util.Scanner;

public class MetaDataDemo2 
{

	public static void main(String[] args) 
	{
		
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_data";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			ResultSetMetaData rdbmeta=rs.getMetaData();
			
			System.out.println("ColumnCount: "+rdbmeta.getColumnCount());
			System.out.println("ColumnDisplaySize: "+rdbmeta.getColumnDisplaySize(3));
			System.out.println("ColumnName: "+rdbmeta.getColumnName(3));
			System.out.println("ColumnLabel: "+rdbmeta.getColumnLabel(2));

			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}

}
