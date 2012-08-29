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
		if(stolenMapInstance == null && stolenMapPresent){
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
		if(!stolenMapPresent){
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
		return "/images/TVaderBase.jpg";
	}



}
