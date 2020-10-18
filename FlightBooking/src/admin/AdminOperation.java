package admin;

import java.sql.*;

public class AdminOperation 
{
	static Connection con;
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
	public void insertFlightDetails(String source,String destination,String servicesprovoider,int ticket)
	{
		PreparedStatement pstmt=null;

		String query="insert into flight_data values(?,?,?,?,?)";

		try
		{
			pstmt=con.prepareStatement(query);
			
			  pstmt.setInt(1, 0);
			  pstmt.setString(2, source);
			  pstmt.setString(3, destination);
			  pstmt.setString(4, servicesprovoider);
			  pstmt.setInt(5, ticket);
			  
			  int count=pstmt.executeUpdate();
			  
			  System.out.println(count+" FLIGHT INSERTED SUCCESSFULLY ");
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, null);
		}

	}
	
	public void removeFlightDetails(int id)
	{
		PreparedStatement pstmt=null;
		
		String query="delete from flight_data where flight_id=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			int count=pstmt.executeUpdate();
			
			if(count==0)
			{
				System.out.println("FLIGHT NOT FOUND");
			}
			else if(count==1)
			{
				System.out.println(count+" FLIGHT DELETED SUCCESSFULLY");
			}
		} 
		catch (SQLException e) 
		{
						e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, null);
		}

	}
	
	public void dispayFlightDetails()
	{
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from flight_data";
		
		try
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			
			System.out.println("ID\tSOURCE\tDESTINATION\tSERVICEPROVOIDER\tTICKETSAVAILABLE");
			System.out.println("-------------------------------------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String source=rs.getString(2);
				String destination=rs.getString(3);
				String service_pro=rs.getString(4);
				int ticket=rs.getInt(5);
				
				System.out.println(id+"\t"+source+"\t"+destination+"\t\t"+service_pro+"\t\t\t\t"+ticket);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, stmt, rs);
		}

		
	}
	
	static void closeCostlyResources(Connection con,Statement stmt,ResultSet rs)
	{
		if(con!=null)
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
