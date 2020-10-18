package procedure;

import java.sql.*;
import java.util.Scanner;

public class DeleteProduct 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			cstmt=con.prepareCall("{call deleteproduct(?)}");
			
			cstmt.setInt(1, id);
			
			cstmt.execute();
			
			System.out.println("PROCEDURE EXECUTED SUCCSSFULLY");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
