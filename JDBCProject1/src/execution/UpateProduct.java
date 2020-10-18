package execution;

import java.sql.*;
import java.util.Scanner;

public class UpateProduct
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID WHICH HAS TO BE UPDATED");
		int id =sc1.nextInt();
		
		System.out.println("ENTER LATEST  PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		Connection con =null;
		Statement stmt=null;
		
		String query="update product_data set product_price="+price+"where product_id="+id;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		    
			stmt=con.createStatement();
			
			int count= stmt.executeUpdate(query);
			
			if(count==0)
			{
				System.out.println("PRODUCT NOT FOUND");
			}
			else
			{
				System.out.println(count+" PRODUCT UPDETED SUCCESSFULL..");
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			sc1.close();

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
