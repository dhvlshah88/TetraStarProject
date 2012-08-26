/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Map.EncryptedStarMap;
import Tetra.Map.IEncrytionStrategy;
import Tetra.Map.Map;


/**
 * @author Dhaval
 *
 */
public class THero extends TRovers {


	//A method to encrypt map/atlas.
	//A method to decrypt map/atlas.
	//A method to make a clone of stolen map.
	//A method to get Tflier.
	//A method to display map.
	//A method to move to a location 

	private IEncrytionStrategy eStrategy;
	private Map map;
	private Map clonedMap;
	private boolean mapPresent = false;

	/*
	 * Default Constructor 
	 */
	public THero(){

	}

	public THero(String name, String tetId, String gender){
		super(name, tetId, gender);
	}

	public void setEncryptionStrategy(IEncrytionStrategy eStrategy){
		this.eStrategy = eStrategy;
	}

	public IEncrytionStrategy getEncryptionStrategy(){
		return eStrategy;
	}


	public Map encryptMap(Map map){
		if(!isMapPresent()){
			this.map = new EncryptedStarMap(map, getEncryptionStrategy(), getTetId(), "", 0, "");
			this.map.setEncrypted(true);
		}
		return this.map;
	}

	public void setMap(Map map){
		if(map != null){
			this.map = map;
			mapPresent = true;
		}
	}

	public Map getMap(){
		return map;
	}
	
	public Map returnMap(){
		Map tempMap;
		tempMap = map;
		initializeMap();
		return tempMap;
	}
	
	public Map returnClonedMap(){
		Map tempMap;
		tempMap = clonedMap;
		clonedMap = null;
		return tempMap;
	}
	
	private void initializeMap(){
		this.map = null;
		mapPresent = false;
	}
	
	public boolean isMapPresent(){
		return mapPresent;
	}

	public void cloneMap(Map map) throws CloneNotSupportedException{
		this.clonedMap = map.clone();
	}

	@Override
	public String getType() {
		return "THero";
	}

	
	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "src/images/Optimus.jpg";
	}
}
