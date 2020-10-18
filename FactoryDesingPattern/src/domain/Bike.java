package domain;

public class Bike implements Vehicle
{

	@Override
	public void getVehicleType() 
	{
		System.out.println("Vehicle Type Is Bike");
	}

	@Override
	public void getVehiclePrice()
	{
		System.out.println("Vehicle Price Is 100000 Rs");
	}

}
