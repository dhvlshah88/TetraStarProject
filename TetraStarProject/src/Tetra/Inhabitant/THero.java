/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Position;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.IEncrytionStrategy;
import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import TetraGUI.StarAtlasView;
import TetraGUI.StarMapView;


/**
 * @author Dhaval
 *
 */
public class THero extends TRovers {

	private IEncrytionStrategy eStrategy;
	private Map map;
	private Map clonedMap;
	private boolean mapPresent = false;
	private boolean clonedMapPresent = false;
	private String mapId = null;

	/**
	 * Default Constructor 
	 */
	public THero(){

	}

	public THero(Position currentPosition){
		super(currentPosition);
	}

	public void setMap(Map map){
		if(map != null && !mapPresent){
			this.map = map;
			this.mapId = map.getMapId();
			mapPresent = true;
		}
	}

	public Map getMap(){
		return map;
	}
	
	public String getMapId(){
		return mapId;
	}
	
	public void setEncryptionStrategy(IEncrytionStrategy eStrategy){
		this.eStrategy = eStrategy;
	}

	public IEncrytionStrategy getEncryptionStrategy(){
		return eStrategy;
	}


	public Map encryptMap(Map map){
		if(!mapPresent){
			this.map = new EncryptedStarMap(map, getEncryptionStrategy(), getTetId(), "", 0, "");
			this.map.setEncrypted(true);
		}
		return this.map;
	}


	public Map returnMap(){
		if(!mapPresent){
			return null;
		}

		Map tempMap;
		tempMap = map;
		this.map = null;
		mapPresent = false;
		return tempMap;
	}

	public Map returnClonedMap(){
		Map tempMap;
		tempMap = clonedMap;
		clonedMap = null;
		return tempMap;
	}


	public boolean isMapPresent(){
		return mapPresent;
	}

	public boolean isCloneMapPresent(){
		return clonedMapPresent;
	}

	public void cloneMap(Map map) throws CloneNotSupportedException{
		this.clonedMap = map.clone();
	}

	@Override
	public String getType() {
		return "THero";
	}

	public void displayMap(Map map){
		String mapType = map.getType();
		if( mapType == "StarMap" || mapType == "EncryptedStarMap"){
			StarMapView starMapView = new StarMapView();
			starMapView.setStarMap(map);
		}else{
			StarAtlasView starAtlasView = new StarAtlasView();
			starAtlasView.setStarAtlas((StarAtlas)map);
		}
	}



	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "src/images/Optimus.jpg";
	}
}
