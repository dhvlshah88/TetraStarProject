package Tetra.Map;

import Tetra.Position;
import Tetra.StarSignal;



public abstract class Map implements Cloneable {

	private static int mapId = 0;
	private String locationId;
	private int itemCount;
	private Position currentPosition = null;

	/*
	 * Default Constructor
	 */
	public Map(){
		
	}

	/*
	 * Initialize values of Map instance.
	 */
	
	public Map(int itemCount, Position currentPosition){
		mapId++;
		this.locationId = currentPosition.getPositionId();
		this.itemCount = itemCount;
		this.currentPosition = currentPosition;
	}
	
	/*
	 * Accessor methods for Star Map
	 */
	
	/*
	 * Gets StarMap Id.
	 */
	public int getMapId(){
		return mapId;
	}
	
	/*
	 * Sets Location Id.
	 */
	public void setPositionId(String positionId){
		this.locationId = positionId;
	}
	
	/*
	 * Gets Location Id.
	 */
	public String getPositionId(){
		return locationId;
	}

	/*
	 * Sets No. of items contained in StarMap.
	 */
	public void setItemCount(int itemCount){
		this.itemCount = itemCount;
	}
	
	/*
	 * Gets No. of items contained in StarMap.
	 */
	public int getItemCount(){
		return itemCount;
	}
	
	/*
	 * Sets current location for Map instance
	 */
	public void setPosition(Position currentPosition){
		this.currentPosition =  currentPosition;
	}
	
	/*
	 * Gets current location for Map instance
	 */
	public Position getPosition(){
		return currentPosition;
	}
	
	/**
	 * this methods returns the Map type of object.
	 */
	@Override
	public Map clone() throws CloneNotSupportedException {
		return (Map) super.clone();
	}
	
	public abstract void setDirection(String direction);
	public abstract String getDirection();
	
	public abstract void setTHeroId(String tHeroId);
	public abstract String getTHeroId();
	
	public abstract void setEncryptionDate(String encryptionDate);
	public abstract String getEncryptionDate();
	
	public abstract void setRestorationCounter(int restorationCounter);
	public abstract int getRestorationCounter();
	
	public abstract void setSymbol(String symbol);
	public abstract String getSymbol();
	
	public abstract boolean isEncrypted();
	public abstract void setEncrypted(boolean encrypted);
	
	public abstract String getType();
	
	public abstract StarSignal showSignal(int mapId, Position heroPosition);
 
}
