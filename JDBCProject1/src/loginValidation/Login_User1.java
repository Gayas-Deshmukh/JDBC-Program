package loginValidation;

import java.sql.*;
import java.util.Scanner;
public class Login_User1 
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
		
		String query="select username,password from login_data";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			boolean b=false;
			while(rs.next())
			{
				String username=rs.getString("username");
				String pass_word=rs.getString("password");
				
				
				if(username.equals(user) && pass_word.equals(password))
				{
					b=true;
				}
				
			}
			if(b==true)
			{
				System.out.println("LOGIN SUCCESSSFULL");
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
