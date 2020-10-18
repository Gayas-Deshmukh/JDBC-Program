package productOperation_2;

import java.sql.*;
import java.util.Scanner;

public class ProductInfo 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("ENTER THE PRODUCT CATEGORY");
		String pro_category=scan.next();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		String query="select product_name from product_data where product_category= '"+pro_category+"' ";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			System.out.println("PRODUCTS UNDER "+pro_category+" CATEGORIES ARE: ");
			
			while(rs.next())
			{
				System.out.println(rs.getString("product_name"));
				
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			scan.close();
			
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
			if(rs!=null)
			{
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

}
