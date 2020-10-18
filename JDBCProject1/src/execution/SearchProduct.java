package execution;

import java.sql.*;

import java.util.Scanner;

public class SearchProduct 
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_data where product_id="+id;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				int pid=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(pid+"\t"+name+"\t"+price);
			}
			else
			{
				System.out.println("PRODUCT NOT FOUND");
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
			sc1.close();
		}


	}

}
