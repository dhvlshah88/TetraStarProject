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
	
	public THeroBase(){
		
	}
	
	public THeroBase(Position basePosition) {
		super(basePosition);
		cloneMapList = new ArrayList<Map>();
	}

	public void addClonedMap(Map cloneMapInstance){
		if(!isMapEmpty(cloneMapInstance)){
			cloneMapList.add(cloneMapInstance);
		}
	}
	
	public boolean isMapEmpty(Map mapInstance){
		if(mapInstance == null){
			return true;
		}
		return false;
	}

	
	public String baseType(){
		return "HeroBase";
	}
	
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
