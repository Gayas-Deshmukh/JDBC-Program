package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo1
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER LOADED AND RESISTERED");

			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			System.out.println("CONNECTION ESTABLISHED");

			stmt=con.createStatement();
			System.out.println("PLATEFORM CREATED SUCCESSFULLY");
		}
		catch (ClassNotFoundException | SQLException e)
		{

			e.printStackTrace();
		}	
		finally
		{
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

}
