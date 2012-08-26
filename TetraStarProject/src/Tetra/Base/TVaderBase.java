/**
 * 
 */
package Tetra.Base;

import Tetra.Position;
import Tetra.Map.Map;


/**
 * @author Dhaval
 *
 */


public class TVaderBase extends Base {


	//This is map reference variable which will contain encrypted star map instance. 
	//For now, we have assumed that vaderbase will contain only one star map.
	private Map stolenMapInstance = null;
	
	//This variable stores boolean value depending on whether map is present in vaderbase or not.
	private boolean stolenMapPresent = false;

	/**
	 * Default Constructor.
	 */
	public TVaderBase(){

	}

	/**
	 * 
	 * @param basePosition
	 */
	public TVaderBase(Position basePosition) {
		super(basePosition, "VB");
	}
	
	/**
	 * 
	 * @param stolenMapInstance
	 */
	public void setMap(Map stolenMapInstance){
		//	if(!isMapEmpty(mapInstance)){
		if(stolenMapInstance == null){
			return;
		}
		
		this.stolenMapInstance = stolenMapInstance;
		stolenMapPresent = true;
	}

	/**
	 * 
	 * @return
	 */
	public Map getMap(){
		return stolenMapInstance;
	}

	/**
	 * 
	 * @return
	 */
	public Map removeMap(){
		if(stolenMapInstance == null){
			return null;
		}

		Map tempMap = getMap();
		stolenMapInstance = null;
		stolenMapPresent = false;

		return tempMap;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMapPresent(){
		return stolenMapPresent;
	}

	/*
	public boolean isMapEmpty(Map mapInstance){
		if(mapInstance == null){
			return true;
		}
		return false;
	}*/


	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#baseType()
	 */
	public String getType(){
		return "VaderBase";
	}

	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#getImageFilePath()
	 */
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}



}
