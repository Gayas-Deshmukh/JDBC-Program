package batchupdate;

import java.sql.*;

public class BatchDemo2
{

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query2="delete  from login_data where id=?";


		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
			
			pstmt=con.prepareStatement(query2);
			
			pstmt.setInt(1, 2);
			
			pstmt.addBatch();
			
			int [] arr=pstmt.executeBatch();
			System.out.println(arr.length+" RECORT AFFECTE");
			
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		
	
	}

}
