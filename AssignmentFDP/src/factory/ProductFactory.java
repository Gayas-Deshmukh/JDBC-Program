package factory;

import domain.Laptop;
import domain.Mobile;
import domain.Product;

public class ProductFactory
{
  public Product getProduct(String  producType)
  {     
	  Product p1=null;
	  
	  if( producType.equalsIgnoreCase("MOBILE"))
	  {
		  p1=new Mobile();
	  }
	  
	  else if(producType.equalsIgnoreCase("LAPTOP"))
	  {
		  p1=new Laptop();
	  }
	  
	  return p1;
  }
}
