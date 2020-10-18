package productOperation_1;

import java.util.Scanner;

public class MainApplication
{

	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		
		DispayProduct1 dp=new DispayProduct1();
		
		System.out.println("SELECT THE PRODUCT TYPE TO BE DISPLAY");
		System.out.println("1: MAXIMUM PRICE PRODUCT");
		System.out.println("2: MINIMUM PRICE PRODUCT");
		int choice=scan.nextInt();
		
		switch(choice)
		{
		case 1: dp.maxPriceProduct();
				
				break;
		
		case 2: dp.minPriceProduct();
		
				break;
		}
	}

}
