package execution;

import java.sql.*;

public class InsertProduct1 
{
	public static void main(String[] args) 
	{
		
		Connection con=null;
		Statement stmt=null;
		
		//create sql query
		
		String query="insert into product_data values(1,'LAPTOP',50000.0)";

         // connectivity steps
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			stmt=con.createStatement();


			int count=stmt.executeUpdate(query);
			System.out.println(count+" PRODUCT INSERTED");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				}
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
			}
		}


	}
}
