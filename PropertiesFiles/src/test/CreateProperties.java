package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreateProperties
{
	public static void main(String[] args) 
	{
		FileWriter f1=null;

		Properties p1=new Properties();

		try 
		{
			f1=new FileWriter("C:\\Workspace\\java program\\J2EE programs\\demo2.properties");

			p1.setProperty("Username", "Admin");
			p1.setProperty("Password", "1234");
			
            p1.store(f1, "External File");
		}

		catch (IOException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			if(f1!=null)
				try 
			{
					f1.close();
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
		}

	}
}
