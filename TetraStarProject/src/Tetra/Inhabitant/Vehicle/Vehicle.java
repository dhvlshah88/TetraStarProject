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
	
	/**
	 * Parameterized constructor.
	 * @param vehicleId
	 */
	public Vehicle(String vehicleId){
		this.vehicleId = vehicleId;
	}
	
	/**
	 * This method sets vehicle id.
	 * @param vehicleId
	 */
	public void setId(String vehicleId){
		this.vehicleId = vehicleId;
	}
	
	/**
	 *  This method gets vehicle id.
	 * @return {@link String}
	 */
	public String getId(){
		return vehicleId;
	}
	
	/**
	 *  This method sets vehicle position on grid.
	 * @param currentPosition
	 */
	public void setPosition(Position currentPosition){
		this.currentPosition = currentPosition;
	}
	
	/**
	 * This method gets vehicle position on grid.
	 * @return {@link Position}
	 */
	public Position getPosition(){
		return currentPosition;
	}

	/**
	 * This method sets vehicle's possession value.
	 * @param vehiclePossessed
	 */
	public void setPossession(boolean vehiclePossessed){
		this.vehiclePossessed = vehiclePossessed;
	}
	
	/**
	 * This method gets vehicle's possession value.
	 * @return {@link Boolean}
	 */
	public boolean isPossessed(){
		return vehiclePossessed;
	}
	
	/**
	 * Abstract method.
	 * @return {@link Position}
	 */
	public abstract Position moveToPosition();
	
	/**
	 * This overrode method compares this object's id with given vehicle object's id. Returns TRUE if compares successfully 
	 * else FALSE. 
	 * @return {@link Boolean}
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vehicle)){
			return false;
		}
		Vehicle vehicle = (Vehicle) obj;
		return this.getId() == vehicle.getId();
	}
}
