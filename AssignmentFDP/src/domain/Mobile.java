package domain;

public class Mobile implements Product
{
	@Override
	public void productType()
	{
		System.out.println("PRODUCT TYPE IS MOBILE");
	}

	@Override
	public void productCost(double price) 
	{
		double gstamount=price*0.10;
		double totalamount=gstamount+price;
		System.out.println("FINAL COST OF MOBILE INCLUDING 10% GST AMOUNT IS: "+totalamount+" Rs");
	}

}
