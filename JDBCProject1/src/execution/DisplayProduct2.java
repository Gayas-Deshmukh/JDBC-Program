package execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayProduct2 
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE MIN PRICE");
		double min_price=sc1.nextDouble();
		
		System.out.println("ENTER THE MAX PRICE");
		double max_price=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_data where product_price between "+min_price+" and "+max_price;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_PRICE");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
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
