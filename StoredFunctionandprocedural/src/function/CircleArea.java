package function;

import java.sql.*;
import java.util.Scanner;

public class CircleArea 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE RADIUS");
		double radius=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			cstmt=con.prepareCall("{?=call circlearea(?)}");
			
			// input placeholder
			cstmt.setDouble(2, radius);
			
			//output placeholder
			cstmt.registerOutParameter(1, Types.DOUBLE);
			
			cstmt.execute();
			
			System.out.println("AREA OF CIRCLE IS: "+cstmt.getDouble(1));
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
			if(cstmt!=null)
			{
				try 
				{
					cstmt.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}

	}

}
