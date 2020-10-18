package test;

import java.util.List;
import java.util.Scanner;

import dao.Bookdao;
import dto.BookModel;

public class BookSimulator
{
	static Scanner sc1=new Scanner (System.in);
	
	public static void main(String[] args)
	{
		System.out.println("SELECT THE MODE OF OPERATION");
		System.out.println("1: ADD NEW BOOK");
		System.out.println("2: DELETE BOOK");
		System.out.println("3: DISPLAY BOOK");
		 int choice=sc1.nextInt();
		 
		switch(choice)
		{
		case 1: storebook();
				break;
				
		case 2: removebook();
				break;
				
		case 3:displaybook();
				break;
				
		}
	}
	public static void storebook()
	{   //accept the value from end user
		System.out.println("ENTER BOOK NAME");
		String bookname=sc1.next();
		System.out.println("ENTER BOOK PRICE");
		double bookprice=sc1.nextDouble();
		System.out.println("ENTER BOOK AUTHOR");
		String author=sc1.next();
		System.out.println("ENTER BOOK QUANTITY");
		int qty=sc1.nextInt();
		
		//pass the value for dto object
		 BookModel bm=new BookModel();
		 bm.setBookName(bookname);
		 bm.setBookPrice(bookprice);
		 bm.setBookAuthor(author);
		 bm.setBookQyt(qty);
		 
		 Bookdao bd=new Bookdao();
		 int count=bd.addbook(bm);
		 
		 //print the output
		 System.out.println(count+" BOOK INSERED SUCCESSFULLY");
	}
	public static void removebook()
	{
		//accept the value from end user
		System.out.println("ENTER THE BOOK ID");
		int bookId=sc1.nextInt();
		
		// pass the value to dto object
		
		BookModel bm=new BookModel();
		bm.setBookId(bookId);
		
		Bookdao bd=new Bookdao();
		int count=bd.deletebook(bm);
		
		//print the output
		System.out.println(count+" BOOK DELETED SUCCESSFULLY");
		
	}
	public static void displaybook()
	{
		Bookdao bd=new Bookdao();
		 List <BookModel> booklist=bd.showbook();
		 System.out.println("BOOKID\tBOOKNAME\tBOOKAUTHOR\tBOOKPRICE\tBOOKQTY");
		 System.out.println("--------------------------------------------------------------------------");
		 for(BookModel b:booklist)
		 {
			 System.out.println(b.getBookId()+"\t"+b.getBookName()+"\t\t"+b.getBookAuthor()+"\t\t"+b.getBookPrice()+"\t\t"+b.getBookQyt());
		 }
	}

}
