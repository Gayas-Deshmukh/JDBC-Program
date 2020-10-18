package domain;

public class Iphone implements Mobile
{
	@Override
	public void getOsType() 
	{
		System.out.println("Os type is IoS");
		
	}

	@Override
	public void getBillAmount(int qty, double price) 
	{
		double totalamount=qty*price;
		System.out.println("Total Amount is: "+totalamount);
		
	}
}
