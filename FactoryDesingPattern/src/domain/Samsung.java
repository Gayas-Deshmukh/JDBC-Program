package domain;

public class Samsung implements Mobile
{

	@Override
	public void getOsType() 
	{
		System.out.println("Os type is Android");
		
	}

	@Override
	public void getBillAmount(int qty, double price) 
	{
		double totalamount=qty*price;
		System.out.println("Total Amount is: "+totalamount);
		
	}

}
