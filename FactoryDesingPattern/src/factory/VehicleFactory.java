package factory;

import domain.Bike;
import domain.Car;
import domain.Vehicle;
//factory class
public class VehicleFactory 
{        //factory method
 public Vehicle getVehicle(String vehicletype)
 {
	 Vehicle v1=null;
	 if(vehicletype.equalsIgnoreCase("car"))
	 {
		 v1=new Car();  //upcasting
		 
	 }
	 else if(vehicletype.equalsIgnoreCase("bike"))
	 {
		 v1=new Bike();  //upcasting
		 
	 }
	 return v1;
 }
}
