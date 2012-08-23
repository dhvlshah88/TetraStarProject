package Tetra.Inhabitant.Vehicle;

import Tetra.Position;

public abstract class Vehicle {
	
	private String vehicleId;
	private Position currentPosition;
	private boolean vehiclePossessed = false;
	
	/**
	 * Default Constructor.
	 */
	public Vehicle(){
		
	}
	
	public Vehicle(String vehicleId){
		this.vehicleId = vehicleId;
	}
	
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

	public void setPossession(boolean vehiclePossessed){
		this.vehiclePossessed = vehiclePossessed;
	}
	
	public boolean isPossessed(){
		return vehiclePossessed;
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
