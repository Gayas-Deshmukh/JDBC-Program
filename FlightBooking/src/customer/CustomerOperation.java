package customer;

import java.sql.*;

public class CustomerOperation
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
	
	//search flight
	public void findFlightDetails(String source,String destination)
	{
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query="select flight_servicepro from flight_data where flight_source=? and flight_destination=?";
	
		try
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			
			rs=pstmt.executeQuery();
			
			System.out.println("SERVICE NAME");
			while(rs.next())
			{
				String service=rs.getString(1);
				System.out.println(service);
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, rs);
		}
		
	}
	
	// book tickets
	
	public void bookFlightTickets(String source,String destination,String serviceprovoider,int tickets)
	{
		//declared sources
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query1="select ticketavailable from flight_data where flight_source=?and flight_destination=?and flight_servicepro=?";
		
		try 
		{
			pstmt=con.prepareStatement(query1);
			
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			pstmt.setString(3, serviceprovoider);
			
			rs=pstmt.executeQuery();
			
			//check the details are currect or not
			if(rs.next())
			{
				int dbticket=rs.getInt("ticketavailable");
				
				//check the tickets are available or not
				
				if(tickets<=dbticket)
				{
					String query2="update flight_data set ticketavailable=? where flight_source=?and flight_destination=?and flight_servicepro=?";
				
					pstmt=con.prepareStatement(query2);
					
					pstmt.setInt(1,dbticket-tickets);
					pstmt.setString(2, source);
					pstmt.setString(3, destination);
					pstmt.setString(4, serviceprovoider);
					
					pstmt.executeUpdate();
					
					//if tickets are available then book the tickets
					System.out.println(tickets+"  TICKETS HAS BEEN BOOKED");
				}
				else
				{
					System.out.println("SORRY TICKETS ARE NOT AVAILABLE");
				}
			}
			else
			{
				System.out.println("PLEASE PROVOID VALIDE FLIGHT DETAILS");
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, rs);
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
