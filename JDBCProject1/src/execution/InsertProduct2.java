package execution;

import java.sql.*;
import java.util.Scanner;

public class InsertProduct2
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); 

		System.out.println("ENTER PRODUCT ID");
		int id=scan.nextInt();

		System.out.println("ENTER PRODUCT NAME");
		String name=scan.next();

		System.out.println("ENTER PRODUCT PRICE");
		double price=scan.nextDouble();

		
		Connection con=null;
		Statement stmt=null;
		
		
		String query="insert into product_data values("+id+",'"+name+"',"+price+")";

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
		}


	}

}
