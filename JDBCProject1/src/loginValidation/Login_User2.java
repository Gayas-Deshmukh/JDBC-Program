package loginValidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login_User2 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER  THE USERNAME");
		String user=sc1.next();
		System.out.println("ENTER THE PASSWORD");
		String password=sc1.next();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from login_data where username='"+user+"' and password='"+password+"'";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("LOGIN SUCCESSFULL");
			}
			else
			{
				System.err.println("INVALID LOGIN DETAILS");
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
