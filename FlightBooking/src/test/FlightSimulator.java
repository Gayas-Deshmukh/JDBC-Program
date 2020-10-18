package test;

import java.util.Scanner;

import customer.CustomerOperation;
import admin.AdminOperation;

public class FlightSimulator 
{
	static Scanner sc1=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("SELECT TYPE OF USER");
		System.out.println("PRESS 1 FOR ADMIN");
		System.out.println("PRESS 2 FOR CUSTOMER");
		
		int choice=sc1.nextInt();
		
		if(choice==1)
		{
			displayAdminOperation();
		}
		else if(choice==2)
		{
			displayCustomerOperation();
		}

	}
	
	static void displayAdminOperation()
	{
		
		System.out.println("1: ADD FLIGHT DETAILS");
		System.out.println("2: DELETE FLIGHT DETAILS");
		System.out.println("3: DISPAY FLIGHT DETAILS");
		int choice =sc1.nextInt();
		
		switch(choice)
		{
		case 1: addFlightDetails();
				break;
				
		case 2: deleteFlightDetails();
				break;
				
		case 3:displayFlightDetails();
				break;
			
		}
	}
	
	static void displayCustomerOperation()
	{ 
		System.out.println("1: SEARCH FLIGHT DETAILS");
		System.out.println("2: BOOK TICKET");
		
		int choice=sc1.nextInt();
		switch(choice)
		{
		case 1: searchFlightDetails();
				break;
				
		case 2: bookTickets();
				break;
		}
		
	}
	
	static void addFlightDetails()
	{
		System.out.println("ENTER THE SOURCE");
		String source=sc1.next();
		
		System.out.println("ENTER THE DESTINATION");
		String destination=sc1.next();
		
		System.out.println("ENTER THE SEVICE PROVOIDER");
		String serviceprovoider=sc1.next();
		
		System.out.println("ENTER THE NO. OF TICKETS AVAILABLE");
		int ticket=sc1.nextInt();
		
		AdminOperation a1= new AdminOperation();
		a1.insertFlightDetails(source, destination, serviceprovoider, ticket);
	}
	
	static void deleteFlightDetails()
	{
		System.out.println("ENTER THE FLIGHT ID");
		int id=sc1.nextInt();
		
		AdminOperation a1= new AdminOperation();
		a1.removeFlightDetails(id);
		
	}
	
	static void displayFlightDetails()
	{
		AdminOperation a1= new AdminOperation();
		a1.dispayFlightDetails();
	}
	
	static void searchFlightDetails()
	{
		System.out.println("ENTER THE SOURCE");
		String source=sc1.next();
		
		System.out.println("ENTER THE DESTINATION");
		String destination=sc1.next();
		
		CustomerOperation c1= new CustomerOperation();
		
		c1.findFlightDetails(source, destination);
	}
	
	static void bookTickets()
	{
		
	 System.out.println("ENTER THE SOURCE");
	 String source=sc1.next();
	 
	 System.out.println("ENTER THE DESTINATION");
	 String destination=sc1.next();
	 
	 System.out.println("ENTER THE SERVICE PROVOIDER");
	 String service_pro=sc1.next();
	 
	 System.out.println("ENTER THE NO OF TICKETS TO BOOK");
	 int tickets=sc1.nextInt();
	 
	 CustomerOperation c1=new CustomerOperation();
	 c1.bookFlightTickets(source, destination, service_pro, tickets);
	 
	}

}
	