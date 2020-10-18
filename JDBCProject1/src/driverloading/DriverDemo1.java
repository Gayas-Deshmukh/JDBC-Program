package driverloading;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DriverDemo1
{
	public static void main(String[] args) 
	{
		try 
		{
			Driver d1=new Driver();
			
			DriverManager.registerDriver(d1);
			System.out.println("DRIVER LOADED AND RESISTERED");
		}

		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}
}
