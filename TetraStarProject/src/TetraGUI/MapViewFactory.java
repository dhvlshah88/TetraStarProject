/**
 * 
 */
package TetraGUI;

import javax.swing.JDialog;

import Tetra.Map.Map;
import Tetra.Map.StarAtlas;

/**
 * @author Dhaval
 *
 */
public class MapViewFactory {
	
	String mapType = null;
	JDialog mapDialog = null;
	
	public MapViewFactory() {
	
	}

	public JDialog createMapView(Map map){

		mapType = map.getType();
		
		if( mapType == "StarMap" || mapType == "EncryptedStarMap"){
			mapDialog = new StarMapView();
			((StarMapView)mapDialog).setStarMap(map);
		}else{
			mapDialog = new StarAtlasView();
			((StarAtlasView)mapDialog).setStarAtlas((StarAtlas)map);
		}
		return mapDialog;
	}
}
