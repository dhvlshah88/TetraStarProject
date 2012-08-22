package Tetra.Inhabitant;

import Tetra.Location;
import Tetra.TFace;


public class TRovers {

	private String gender;
	private String tetId;
	private String name;
	private Location currentLocation;
	private Location vaderBaseLocation;
	private TFace tface;
	
	/*
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
	
	public void setTetId(String tetId){
		this.tetId = tetId;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getTetId(){
		return tetId;
	}
	
	
	public String getGender(){
		return gender;
	}
	
	
	public void showMap(){
		
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
	public TFace getTface() {
		return tface;
	}
	
	public void setTface(TFace tface) {
		this.tface = tface;
	}
		
	public String getType(){
		return "TRover";
	}
	
}
