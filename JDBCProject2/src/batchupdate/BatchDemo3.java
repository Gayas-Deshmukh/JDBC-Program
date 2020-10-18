package batchupdate;

import java.sql.*;

public class BatchDemo3 {

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="delete from mysql.product_data where product_id=4";
		String query2="delete from sample.student_data where student_id=2";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Gayas@123");
			
			stmt=con.createStatement();
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			
			int [] arr=stmt.executeBatch();
			
			System.out.println(arr.length+" RECORD AFFECTED");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		

	}

}
