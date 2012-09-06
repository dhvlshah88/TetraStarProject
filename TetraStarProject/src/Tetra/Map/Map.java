package Tetra.Map;

import java.util.ArrayList;
import java.util.Iterator;

import Tetra.ILocatable;
import Tetra.Position;



public abstract class Map implements Cloneable, ILocatable {

	private String mapId = null;
	private String locationId = null;
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
	
	public Map(Position currentPosition, String mapId){
		this.mapId = mapId ;
		this.locationId = currentPosition.getPositionId();
		this.itemCount = 0;
		this.currentPosition = currentPosition;
	}
	
	/*
	 * Accessor methods for Star Map
	 */
	
	/*
	 * Gets StarMap Id.
	 */
	public String getMapId(){
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
	 * this methods returns clone of Map type of object.
	 */
	@Override
	public Map clone() throws CloneNotSupportedException {
		return (Map)super.clone();
	}
	
	/**
	 * 
	 * @param mapId
	 * @param heroPosition
	 * @return {@link StarSignal}
	 * 
	 */
	public  StarSignal showSignal(String mapId){
		StarSignal signal = new StarSignal();

		if(this.getMapId() == mapId){
			signal.setMapPresent();
		}

		return signal;
	}
	
	public abstract void setDirection(String direction);
	public abstract String getDirection();
	
	public abstract void setTHeroId(String tHeroId);
	public abstract String getTHeroId();
	
	public abstract void setEncryptionDate(String encryptionDate);
	public abstract String getEncryptionDate();
	
	public abstract void setRestorationCounter(int restorationCounter);
	public abstract int getRestorationCounter();
	
	public abstract void addStarMap(Map starMap);
	public abstract void setStarMapList(ArrayList<Map> mapList);
	public abstract ArrayList<Map> getStarMapList();
	
	public abstract void setSymbol(String symbol);
	public abstract String getSymbol();
	
	public abstract boolean isEncrypted();
	public abstract void setEncrypted(boolean encrypted);
	
	public abstract String getType();
	public abstract String getImageFilePath();

}
