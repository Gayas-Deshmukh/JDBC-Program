package productOperation_1;

import java.sql.*;

public class DispayProduct1
{
	static Connection con=null;
	
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
	public void maxPriceProduct()
	{ 
		Statement stmt=null;
		ResultSet rs=null;

		String query="select * from product_data where product_price=(select max(product_price)from product_data)";

		try
		{
			stmt=con.createStatement();

			rs=stmt.executeQuery(query);

		if(rs.next())
		{
			int id=rs.getInt("product_id");
			String name=rs.getString("product_name");
			double price=rs.getDouble("product_price");
			System.out.println("PRODUCT ID IS "+id);
			System.out.println("PRODUCT NAME IS "+name);
			System.out.println("PRODUCT PRICE IS "+price);

		}
		} 
		catch (SQLException e)
		{

			e.printStackTrace();
		}

	}

	public void minPriceProduct()
	{
		
		Statement stmt=null;
		ResultSet rs=null;

		String query="select * from product_data where product_price=(select min(product_price)from product_data)";

		try
		{
			stmt=con.createStatement();

			rs=stmt.executeQuery(query);

		if(rs.next())
		{
			int id=rs.getInt("product_id");
			String name=rs.getString("product_name");
			double price=rs.getDouble("product_price");
			System.out.println("PRODUCT ID IS "+id);
			System.out.println("PRODUCT NAME IS "+name);
			System.out.println("PRODUCT PRICE IS "+price);

		}
		} 
		catch (SQLException e)
		{

			e.printStackTrace();
		}


	}

}
