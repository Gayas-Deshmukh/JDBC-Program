package dao;

import java.util.*;
import java.sql.*;

import dto.BookModel;
public class Bookdao 
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
	public int addbook(BookModel bd)
	{   
		int count=0;
		PreparedStatement pstmt=null;
		
		String query="insert into book_data values(?,?,?,?,?)";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			//accept the value fron dto object
			pstmt.setInt(1, 0);
			pstmt.setString(2, bd.getBookName());
			pstmt.setDouble(3, bd.getBookPrice());
			pstmt.setString(4, bd.getBookAuthor());
			pstmt.setInt(5, bd.getBookQyt());
			
		    count=pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int deletebook(BookModel bm)
	{	
		int count=0;
		PreparedStatement pstmt=null;
		
		String query="delete from book_data where book_id=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, bm.getBookId());
			
			   count=pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return count;
		
		
	}
	
	public List<BookModel> showbook()
	{
		Statement stmt=null;
		ResultSet rs=null;
		
		List <BookModel>booklist= new ArrayList<BookModel>();
		
		String query="select * from book_data";
		
		try
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int bookId=rs.getInt(1);
				String bookName=rs.getString(2);
				double bookprice=rs.getDouble(3);
				String bookAuthor=rs.getString(4);
				int bookqty=rs.getInt(5);
				
				//pass value to bto object
				
				BookModel bm=new BookModel();
				bm.setBookId(bookId);
				bm.setBookName(bookName);
				bm.setBookAuthor(bookAuthor);
				bm.setBookPrice(bookprice);
				bm.setBookQyt(bookqty);
				
				booklist.add(bm);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return booklist;
	}
}
