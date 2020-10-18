package execution;

import java.sql.*;

public class DisplayProducts
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
			
			while(rs.next())
			{
				int id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				double price=rs.getDouble("product_price");
				System.out.println("PRODUCT ID IS "+id);
				System.out.println("PRODUCT NAME IS "+name);
				System.out.println("PRODUCT PRICE IS "+price);
				
				System.out.println("----------------------------------------");

			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			try
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			try
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}

	}

}
