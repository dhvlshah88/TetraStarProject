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
public class MapBase extends Base {

	private Map mapInstance = null;
	private String mapId = null;
	private boolean mapPresent = false;

	public MapBase(){

	}

	public MapBase(Position basePosition) {
		super(basePosition, "M");
		
	}
	
	public void setMap(Map mapInstance){
		if(mapPresent){
			return;
		}
		
		this.mapInstance = mapInstance;
		this.mapId = mapInstance.getMapId();
		mapPresent = true;
	}

	public Map getMap(){
		return mapInstance;
	}
	
	public Map removeMap(){
		if(!mapPresent){
			return null;
		}
		
		Map tempMap = mapInstance;
		mapInstance = null;
		mapPresent = false;
		return tempMap;
	}
	
	public String getMapId(){
		return mapId;
	}

	public void setMapPresent(boolean mapPresent){
		this.mapPresent = mapPresent;
	}
	
	public boolean isMapPresent(){
		return mapPresent;
	}

	public String getType(){
		return "MapBase";
	}

	@Override
	public String getImageFilePath() {
		return "/images/MapBase.jpg";
	}

}
