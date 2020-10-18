package model;
// BLC
public class Customer 
{
	public String customerName;
	public String customerAddress;

	public Customer(String customerName, String customerAddress) 
	{

		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	
	public void displayCustomerinfo()
	{
		System.out.println("Customer Name is: "+customerName);
		System.out.println("Customer Address is: "+customerAddress);
	}

}
