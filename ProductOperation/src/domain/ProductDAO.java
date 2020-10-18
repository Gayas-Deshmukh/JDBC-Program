package domain;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDAO 
{     static  Connection con;
static
{

	try 
	{
		Class.forName("com.mysql.jdbc.Driver");

		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

	} 
	catch (ClassNotFoundException | SQLException e)
	{

		e.printStackTrace();
	}

}
public void addProduct(String name,double price)
{
	Statement stmt=null;

	String query="insert into product_data (product_name,product_price)values('"+name+"',"+price+")";

	try 
	{
		stmt=con.createStatement();

		int count=stmt.executeUpdate(query);

		System.out.println(count+" PRODUCT INSERTED");
	}
	catch (SQLException e)
	{

		e.printStackTrace();
	}


}

public void removeProduct(int id)
{
	Statement stmt=null;
	
	String query= "delete from product_data where product_id="+id;

	try 
	{
		stmt=con.createStatement();

		int count =stmt.executeUpdate(query);
		
		if(count==0)
		{
			System.out.println("PRODUCT NOT FOUNT");
		}
		else
		{
			System.out.println(count+" PRODUCT DELETED SUCCESSFULLY");
		}
	}
	catch (SQLException e) 
	{

		e.printStackTrace();
	}
}
}
