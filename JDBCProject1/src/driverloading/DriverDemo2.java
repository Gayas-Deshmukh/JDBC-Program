package driverloading;

public class DriverDemo2 
{

	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER LOADED AND RESISTERED");
		} 
		catch (ClassNotFoundException e)
		{

			e.printStackTrace();
		}
	}

}
