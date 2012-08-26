package Tetra.Inhabitant;

import Tetra.Location;
import Tetra.TFace;
import Tetra.Inhabitant.Movement.IMoveStrategy;


public class TRovers {

	private String gender;
	private String tetId;
	private String name;
	private Location currentLocation;
	private Location vaderBaseLocation;
	private TFace tface;
	private IMoveStrategy movementStrategy;
	
	/**
	 * Default Constructor
	 */
	public TRovers(){
		
	}
	
	/**
	 * This is a constructor
	 * @param name
	 * @param tetId
	 * @param gender
	 */
	public TRovers(String name, String tetId, String gender){
		this.name = name;
		this.tetId = tetId;
		this.gender = gender;
	}
	/**
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @param tetId
	 */
	public void setTetId(String tetId){
		this.tetId = tetId;
	}
	
	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTetId(){
		return tetId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * 
	 * @return
	 */
	public Location getVaderBase() {
		return vaderBaseLocation;
	}

	/**
	 * @return
	 */
	public Location getLocation() {
		return currentLocation;
	}
	
	/**
	 * 
	 * @param currentLocation
	 */
	public void setLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	/**
	 * 
	 * @return
	 */
	public TFace getTface() {
		return tface;
	}
	
	/**
	 * 
	 * @param tface
	 */
	public void setTface(TFace tface) {
		this.tface = tface;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getType(){
		return "TRover";
	}
	
	/**
	 * 
	 * @param movementStrategy
	 */
	public void setMovementStrategy(IMoveStrategy movementStrategy){
		this.movementStrategy = movementStrategy;
	}

	/**
	 * 
	 * @return
	 */
	public IMoveStrategy getMovementStrategy(){
		return movementStrategy;
	}
	
	public void moveToLocation(Location nextLocation){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "src/images/BumbleBee.jpg";
	}
	
}
