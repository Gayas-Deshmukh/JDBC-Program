package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Sample1 
{
	public static void main(String[] args)
	{
		FileWriter  f1=null;

		Properties p1=new Properties();

		Scanner scan=new Scanner(System.in);

		try 
		{
			f1=new FileWriter("C:\\Workspace\\java program\\J2EE programs\\employee.properties");

			System.out.println("Enter Employee Name");
			String name=scan.next();

			System.out.println("Enter Employee Age");
			String age=scan.next();

			p1.setProperty(name, age);

			p1.store(f1, "Employees Details");
		} 

		catch (IOException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			if(f1!=null)
			{
				try 
				{
					f1.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				scan.close();
			}
		}
	}
}
