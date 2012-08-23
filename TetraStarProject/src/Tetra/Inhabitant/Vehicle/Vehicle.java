package Tetra.Inhabitant.Vehicle;

import Tetra.Position;

public abstract class Vehicle {
	
	private String vehicleId;
	private Position currentPosition;
	
	
	public void setId(String vehicleId){
		this.vehicleId = vehicleId;
	}
	
	public String getId(){
		return vehicleId;
	}
	
	public void setCurrentPosition(Position currentPosition){
		this.currentPosition = currentPosition;
	}
	
	public Position getCurrentPosition(){
		return currentPosition;
	}

	public abstract Position moveToPosition();
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vehicle)){
			return false;
		}
		Vehicle vehicle = (Vehicle) obj;
		return this.getId() == vehicle.getId();
	}
}
