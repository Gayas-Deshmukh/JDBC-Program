package factory;

import domain.Iphone;
import domain.Mobile;
import domain.Samsung;

public class MobileFactory 
{
  public  Mobile getmobile(int mobiletype)
  {
	  Mobile m1=null;
	  switch(mobiletype)
	  {
	  case 1: m1=new Samsung();
	            break;
	          
	  case 2: m1=new Iphone();
	           break;
	  }
	  return m1;
  }
}
