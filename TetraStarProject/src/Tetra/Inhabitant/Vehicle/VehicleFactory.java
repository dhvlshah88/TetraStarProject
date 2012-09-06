package Tetra.Inhabitant.Vehicle;

public class VehicleFactory {
	
	private Vehicle vehicle = null;
	
	public Vehicle createVehicle(String vehicleType){
		if(vehicleType.equalsIgnoreCase("TFlier")){
			vehicle = new TFlier();
		}
		
		return vehicle;
	}
	
}