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
public class TVaderBase extends Base {


	private Map mapInstance;
	private ArrayList<Map> stolenMapList = null;

	public TVaderBase(){

	}

	public TVaderBase(Position basePosition) {
		super(basePosition);
		stolenMapList = new ArrayList<Map>();
	}

	/**
	private static final long serialVersionUID = -1197783474784364993L;

	private ArrayList<TRovers> troverList = null;

	private TRovers vader = null;
	private boolean vaderPresent = false;
	private Map stolenMap = null;

	//Constructor
	public TVaderBase(Location location) {
		super(location);
	}

	//This method creates TVader instance. This is client for creating TVader instance.
	public void spawnTVader(){
		TRoverFactory roverFactory = new TRoverFactory();
		this.vader = roverFactory.createTRover("TVader");
	}

	// This method sets TVader instance.
	public void setVader(TVader vader){
		this.vader = vader;
	}

	public TVader getVader(){
		return (TVader)vader;
	}

	public void enterBase(TRovers trover){
		if(trover instanceof TVader){
			if(vaderPresent){
				return;
			}
			setVader((TVader) trover);
			vaderPresent = true;
			return;
		}

		if(trover instanceof THero){
			troverList.add(trover);
			return;
		}

		//Message saying Trover cannot enter vaderbase.
	}


	public void setMap(Map map){
		this.stolenMap = map;
	}

	public Map getMap(){
		return stolenMap;
	}
	 * 
	 */

	public void addMap(Map mapInstance){
		if(!isMapEmpty(mapInstance)){
			stolenMapList.add(mapInstance);
		}
	}

	public boolean isMapEmpty(Map mapInstance){
		if(mapInstance == null){
			return true;
		}
		return false;
	}


	public String baseType(){
		return "VaderBase";
	}

	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}



}
