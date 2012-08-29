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
	
	/**
	 * @return
	 */
	public String getType(){
		return "HeroBase";
	}

	/**
	 * @return
	 */
	@Override
	public String getImageFilePath() {
		return "/images/THeroBase.jpg";
	}
}
