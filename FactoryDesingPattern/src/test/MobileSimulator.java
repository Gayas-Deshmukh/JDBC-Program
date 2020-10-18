package test;

import java.util.Scanner;

import domain.Mobile;
import factory.MobileFactory;

public class MobileSimulator 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Select Mobile");
		System.out.println("1: Samsung ");
		System.out.println("2: Iphone ");

		int choice=scan.nextInt();

		//create an object of factory class
		MobileFactory m1=new MobileFactory();
		Mobile m=m1.getmobile(choice);

		//accept the value from end user

		System.out.println("Enter mobile price");
		double price=scan.nextDouble();

		System.out.println("Enter mobile quantity");
		int qty=scan.nextInt();

		//call the method of BLC
		
	    m.getOsType();
		m.getBillAmount(qty, price);


	}

}
