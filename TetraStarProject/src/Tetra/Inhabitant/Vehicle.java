package Tetra.Inhabitant;

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

	
}
