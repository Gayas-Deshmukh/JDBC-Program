package batchupdate;

import java.sql.*;

public class BatchDemo1 
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		
		String qurey1="insert into login_data values(0,'delhi','hi')";
		String query2="delete  from login_data where id=1";
		String query3="update product_data  set product_name='AirPhone' where product_id=4";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			stmt=con.createStatement();
			stmt.addBatch(qurey1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			 int []arr=stmt.executeBatch();
			 System.out.println(arr.length+" RECORD AFFECTED");
					 
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
	}

}
