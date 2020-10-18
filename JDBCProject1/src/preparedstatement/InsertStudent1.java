package preparedstatement;

import java.sql.*;

public class InsertStudent1 
{

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="insert into student_data values(0,'AMOL',84.25,'ME')";
		String query2="insert into student_data values(0,'NITIN',65.24,'CS')";
		String query3="insert into student_data values(0,'RAHUL',70.21,'CIVIL')";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			stmt=con.createStatement();
			
			int count1=stmt.executeUpdate(query1);
			
			int count2=stmt.executeUpdate(query2);
			
			int count3=stmt.executeUpdate(query3);
			
			System.out.println(count1+count2+count3+" RECORED INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
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
		}

	}

}
