package procedure;

import java.sql.*;
import java.util.Scanner;

public class DispalyStudent 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE STUDENT STREAM");
		String stream=sc1.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			cstmt=con.prepareCall("{call displacount(?,?)}");
			
			cstmt.setString(1, stream);
			
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.execute();
			
			System.out.println("TOTAL NO.OF STUDENTS ARE: "+cstmt.getInt(2));
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
