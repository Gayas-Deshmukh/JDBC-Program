package procedure;

import java.sql.*;
import java.util.Scanner;

public class Displaytext
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE STUDENT NAME");
		String name=sc1.next();

		Connection con=null;
		CallableStatement cstmt=null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			cstmt=con.prepareCall("{call showtext(?)}");
			
			cstmt.setString(1, name);
			
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println(cstmt.getString(1));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
