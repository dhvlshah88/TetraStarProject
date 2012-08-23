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
	
	/*
	 * Default Constructor.
	 */
	public THeroBase(){

	}

	public THeroBase(Position basePosition) {
		super(basePosition);
		cloneMapList = new ArrayList<Map>();
	}

	/*
	 * 
	 */
	public void addClonedMap(Map cloneMapInstance){
		//if(!isMapEmpty(cloneMapInstance)){
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

	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#baseType()
	 */
	public String baseType(){
		return "HeroBase";
	}

	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
