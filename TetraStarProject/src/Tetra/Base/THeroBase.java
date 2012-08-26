/**
 * 
 */
package Tetra.Base;

import java.util.ArrayList;

import Tetra.Position;
import Tetra.Map.Map;

/**
 * @author Dhaval
 *
 */
public class THeroBase extends Base {

	private ArrayList<Map> cloneMapList = null;
	
	/**
	 * Default Constructor.
	 */
	public THeroBase(){

	}

	/**
	 * 
	 * @param basePosition
	 */
	public THeroBase(Position basePosition) {
		super(basePosition, "HB");
		cloneMapList = new ArrayList<Map>();
	}
	
	/**
	 * 
	 * @param cloneMapInstance
	 */
	public void addMap(Map cloneMapInstance){
		if(cloneMapInstance == null){
			return;
		}
		cloneMapList.add(cloneMapInstance);
	}
	
	/*public boolean isMapEmpty(Map mapInstance){
		if(mapInstance == null){
			return true;
		}
		return false;
	} */

	
	/**
	 * @return
	 */
	public String baseType(){
		return "HeroBase";
	}

	/**
	 * @return
	 */
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
