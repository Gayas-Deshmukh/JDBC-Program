package test;

import java.util.Scanner;
import domain.Product;
import factory.ProductFactory;

public class ProductSimulator
{
	public static void main(String[] args) 
	{
		Scanner scan =new Scanner(System.in);
		System.out.println("SELECT PRODUCT TYPE: ");
		System.out.println("LAPTOP");
		System.out.println("MOBILE");

		String choice= scan.next();

		ProductFactory pf=new ProductFactory();
		Product pd=pf.getProduct(choice);

		System.out.println("ENTER PRODUCT PRICE");
		int price=scan.nextInt();

		pd.productType();
		pd.productCost(price);




	}
}
