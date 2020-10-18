package preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class StoreImageFile 
{

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		String query="insert into cource_data values(?,?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=Gayas@123");
		
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, "sql");
			
			//locate the image file
			fin=new FileInputStream("G:\\images\\sql.png");
			
			pstmt.setBinaryStream(3, fin);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" RECORD INSERTED SUCCESSFULLY");
			
		} 
		catch (ClassNotFoundException | SQLException | FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		 
		

	}

}
