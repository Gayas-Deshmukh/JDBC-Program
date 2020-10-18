package preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class DisplayStudentDetails 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER STUDENT STREAM");
		String stream=sc1.next();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String query="select student_name from student_data where student_stream=?and Student_percantage>70.00";

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");

			pstmt=con.prepareStatement(query);

			pstmt.setString(1, stream);

			rs=pstmt.executeQuery();
			System.out.println("FOLLOWING ARE THE STUDENTS:");

			while(rs.next())
			{
				String name=rs.getString("student_name");
				System.out.println(name);
			}


		} 
		catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			sc1.close();
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

}
