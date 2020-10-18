package domain;

public class Laptop implements Product
{

	@Override
	public void productType()
	{
		System.out.println("PRODUCT TYPE IS LAPTOP");
	}

	@Override
	public void productCost(double price) 
	{
		double gstamount=price*0.05;
		double totalamount=gstamount+price;
		System.out.println("FINAL COST OF LAPTOP INCLUDING 5% GST AMOUNT IS: "+totalamount+" Rs");
	}

}
