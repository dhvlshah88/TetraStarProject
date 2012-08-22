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
	private String mapType;
	private boolean mapPresent = false;
	
	public MapBase(){
		
	}
	
	public MapBase(Position basePosition) {
		super(basePosition);
	}
	
	
	public void setMap(Map mapInstance){
		if(isMapEmpty(this.mapInstance) && !isMapEmpty(mapInstance)){
			this.mapInstance = mapInstance;
			mapPresent = true;
		}
	}

	public Map getMap(){
		return mapInstance;
	}
	
	public boolean isMapEmpty(Map mapInstance){
		if(mapInstance == null){
			return true;
		}
		return false;
	}

	public boolean isMapPresent(){
		return mapPresent;
	}
	
	public String getMapType(){
		if(mapInstance != null){
			mapType = mapInstance.getType();
			return mapType;
		}

		return "Stolen";
	}


	public String baseType(){
		return "MapBase";
	}
	
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
