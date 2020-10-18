package preparedstatement;

import java.sql.*;

public class InsertStudent2 
{

	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;

		String query="insert into student_data values(?,?,?,?)";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
			
			pstmt=con.prepareStatement(query);  //compilation
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, "SHUBHAM");
			pstmt.setDouble(3, 85.24);
			pstmt.setString(4, "EEE");
			
			int count1=pstmt.executeUpdate();
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, "MANOJ");
			pstmt.setDouble(3, 60.84);
			pstmt.setString(4, "IT");
			
			int count2=pstmt.executeUpdate();
			
			System.out.println(count1+count2+" RECORD INSERTED");

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
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
		}


	}

}
