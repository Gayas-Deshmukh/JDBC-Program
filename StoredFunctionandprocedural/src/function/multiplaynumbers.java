package function;

import java.sql.*;
import java.util.Scanner;

public class multiplaynumbers
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER FIRST NO");
		double no1=sc1.nextDouble();
		System.out.println("ENTER SECOND NO");
		double no2=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
			
			cstmt=con.prepareCall("{?=call multiplaynumbers(?,?)}");
			
			//inpute placeholder
			cstmt.setDouble(2, no1);
			cstmt.setDouble(3, no2);
			//output placeholder
			cstmt.registerOutParameter(1, Types.DOUBLE);
			
			cstmt.execute();
			
			System.out.println("MULTIPLICATION IS :"+cstmt.getDouble(1));
			
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
