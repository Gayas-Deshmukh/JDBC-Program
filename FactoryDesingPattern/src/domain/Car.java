package domain;

public class Car implements Vehicle
{
	@Override
	public void getVehicleType() 
	{
		System.out.println("Vehicle Type Is Car");
	}

	@Override
	public void getVehiclePrice()
	{
		System.out.println("Vehicle Price Is 1000000 Rs");
	}
}
