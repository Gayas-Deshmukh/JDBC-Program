package test;

import java.util.Scanner;

import domain.Car;
import domain.Vehicle;
import factory.VehicleFactory;

public class VehicleSimulator 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Select Vehicle Type");
		System.out.println("Car");
		System.out.println("Bike");
		
		String choice=scan.next();
		
		VehicleFactory v1=new VehicleFactory();
		 
		Vehicle v = v1.getVehicle(choice);
		 v.getVehicleType();
		 v.getVehiclePrice();
	}
}
