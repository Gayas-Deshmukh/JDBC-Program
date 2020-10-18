package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties
{

	public static void main(String[] args) 
	{
		FileReader f=null;

		Properties p=new Properties();

		try 
		{
			f=new FileReader("C:\\Workspace\\java program\\J2EE programs\\demo.properties");

			p.load(f);

			String cityname = p.getProperty("city","Key Not Found");
			String statename = p.getProperty("state");

			System.out.println("City Name is: "+cityname);
			System.out.println("State Name is: "+statename);

		} 
		catch ( IOException e)
		{
			e.printStackTrace();
		}

		finally
		{
			if(f!=null)
			{
				try 
				{
					f.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

		}

	}
}