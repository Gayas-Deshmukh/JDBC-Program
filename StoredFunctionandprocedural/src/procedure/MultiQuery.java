package procedure;

import java.sql.*;
import java.util.Scanner;

public class MultiQuery {

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT NAME");
		String pname=sc1.next();
		System.out.println("ENTER PRODUCT PRICE");
		double pprice=sc1.nextDouble();
		System.out.println("ENTER PRODUCT CATEGORY");
		String category=sc1.next();
		
		System.out.println("ENTER THE ID TO DELETE THE RECORD");
		int id =sc1.nextInt();
		
		System.out.println("ENTER THE PRICE TO BE UPDATE");
		double price=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			cstmt=con.prepareCall("{call insertdata(?,?,?,?,?,?)}");
			
			// placeholder for insert query
			cstmt.setString(1, pname);
			cstmt.setDouble(2, pprice);
			cstmt.setString(3, category);
			
			//placehoder for delete query
			cstmt.setInt(4, id);
			
			//placehoder for update query
			cstmt.setDouble(5, price);
			
			//placehoder for select query
			cstmt.registerOutParameter(6, Types.VARCHAR);
			
			cstmt.execute();
			System.out.println("FLIGHT INFO: "+cstmt.getString(6));
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		

	}

}
