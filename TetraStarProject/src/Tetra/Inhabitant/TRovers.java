package Tetra.Inhabitant;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.Movement.IMoveStrategy;


public class TRovers implements ILocatable {

	private String gender;
	private String tetId;
	private String name;
	private Position currentPosition;
	private Position vaderBaseLocation;
	private TFace tface;
	private IMoveStrategy movementStrategy;
	
	/**
	 * Default Constructor
	 */
	public TRovers(){
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param currentPosition denotes <i>current position of TRover.</i>
	 */
	public TRovers(Position currentPosition){
		this.currentPosition = currentPosition;
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
	public Position getVaderBase() {
		return vaderBaseLocation;
	}

	
	/**
	 * 
	 * @param currentPosition
	 */
	public void setPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	/**
	 * @return
	 */
	public Position getPosition() {
		return currentPosition;
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
	public TFace getTface() {
		return tface;
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
	
	public void moveToLocation(Position nextLocation){
		
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
	 * @return
	 */
	public String getImageFilePath(){
		return "src/images/BumbleBee.jpg";
	}
	
}
