package Tetra.Inhabitant.Vehicle;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.Movement.IMovementStrategy;

public abstract class Vehicle implements ILocatable {
	
	private String vehicleId;
	private Position currentPosition;
	private boolean vehiclePossessed = false;
	private IMovementStrategy movementStrategy = null;
	private TFace tfaceObj = null;
	
	/**
	 * Default Constructor.
	 */
	public Vehicle(){
		
	}
	
	/**
	 * Parameterized constructor.
	 * @param vehicleId
	 */
	public Vehicle(TFace tfaceObj, String vehicleId){
		this.tfaceObj = tfaceObj;
		this.vehicleId = vehicleId;
	}
	
	/**
	 * 
	 * @param tfaceObj
	 */
	public void setTface(TFace tfaceObj){
		this.tfaceObj = tfaceObj;
	}
	
	/**
	 * 
	 * @return {@link TFace} - TFace object
	 */
	public TFace getTface(){
		return tfaceObj;
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
	 * 
	 * @param movementStrategy
	 */
	public void setMovementStrategy(IMovementStrategy movementStrategy){
		this.movementStrategy = movementStrategy;
	}

	/**
	 * 
	 * @return
	 */
	public IMovementStrategy getMovementStrategy(){
		return movementStrategy;
	}
	
	/**
	 * Abstract method.
	 * @return {@link Position}
	 */
	public abstract Position moveToPosition(Position currentPosition);
	
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

	public String getImageFilePath() {
		return "/images/TFlier.jpg";
	}
}
