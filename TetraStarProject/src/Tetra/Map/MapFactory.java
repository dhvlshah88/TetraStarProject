/**
 * 
 */
package Tetra.Map;

import Tetra.Position;
import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import Tetra.Map.StarMap;

/**
 * @author pranav
 *
 */
public class MapFactory {

	private Map map = null;

	public MapFactory() {

	}

	public Map createMap(String type, Position position, String mapId){
		if(type.equalsIgnoreCase("StarMap")){
			map= new StarMap(position, mapId);
		}
		else if(type.equalsIgnoreCase("StarAtlas")){
			map= new StarAtlas(position, mapId);
		}
		return map;
	}

}
