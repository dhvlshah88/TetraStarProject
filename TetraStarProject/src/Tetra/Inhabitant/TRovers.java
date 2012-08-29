package Tetra.Inhabitant;

import Tetra.ILocatable;
import Tetra.TInhabitantCollection;
import Tetra.Logger;
import Tetra.Position;
import Tetra.TFace;
import Tetra.Base.MapBase;
import Tetra.Base.River;
import Tetra.Base.THeroBase;
import Tetra.Base.TVaderBase;
import Tetra.Inhabitant.Movement.IMovementStrategy;
import Tetra.Inhabitant.Vehicle.Vehicle;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import TetraGUI.StarAtlasView;
import TetraGUI.StarMapView;


public class TRovers implements ILocatable {

	private String gender;
	private String tetId;
	private String name;
	private Position currentPosition = null;
	private Position vaderBasePosition = null;
	private TFace tface;
	private IMovementStrategy movementStrategy = null;
	private TInhabitantCollection locatableColl = null;
	private ILocatable locatableObj = null;
	
	/**
	 * Default Constructor
	 */
	public TRovers(){

	}

	/**
	 * Parameterized Constructor
	 * @param currentPosition denotes <i>current position of TRover.</i>
	 */
	public TRovers(Position currentPosition){
		this.currentPosition = currentPosition;
	}

	/**
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * 
	 * @param tetId
	 */
	public void setTetId(String tetId){
		this.tetId = tetId;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}

	/**
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public String getTetId(){
		return tetId;
	}

	/**
	 * 
	 * @return
	 */
	public String getGender(){
		return gender;
	}

	/**
	 * 
	 * @return
	 */
	public void setVaderBasePosition(TVaderBase base){
		this.vaderBasePosition = base.getPosition();
	}

	/**
	 * 
	 * @return
	 */
	public Position getVaderBasePosition(){
		return vaderBasePosition;
	}

	/**
	 * 
	 * @param currentPosition
	 */
	public void setPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	/**
	 * @return
	 */
	public Position getPosition() {
		return currentPosition;
	}

	/**
	 * 
	 * @param tface
	 */
	public void setTface(TFace tface) {
		this.tface = tface;
	}


	/**
	 * 
	 * @return
	 */
	public TFace getTface() {
		return tface;
	}

	/**
	 * 
	 * @param movementStrategy
	 */
	public void setMovementStrategy(IMovementStrategy movementStrategy){
		this.movementStrategy = movementStrategy;
	}

	/**
	 * 
	 * @return
	 */
	public IMovementStrategy getMovementStrategy(){
		return movementStrategy;
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


	/*public void moveToPosition(){
		nextPosition = this.getMovementStrategy().getNewPosition(this.getPosition());
		moveToPosition(nextPosition);
	}*/

	public void moveToPosition(Position nextPosition){
		/*if(!presentInBase){
			if(locatableColl.objectAt(nextPosition)){
				locatableObj = locatableColl.getLocatableAtPosition(nextPosition);

				if(locatableObj instanceof TRovers){
					return;
				}

				if(locatableObj instanceof River || locatableObj instanceof THeroBase || locatableObj instanceof TVaderBase){
					return;
				}else{
					presentInBase = true;
				}
			}else{
				this.enterMapBase(locatableObj);
			}
		}*/

		locatableColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
	}

	public void enterMapBase(ILocatable locatableObj){
		Logger.DisplaySteps("TRover " + this.getTetId() + " enters map base.");

		MapBase mapBase = (MapBase) locatableObj;
		if(mapBase.isMapPresent()){
			Map map = mapBase.getMap();
			Logger.DisplaySteps("TRover " + this.getTetId() + " found the map " + map.getMapId() + ".");
			this.displayMap(map);
		}
	}


	/**
	 * 
	 * @return
	 */
	public String getType(){
		return "TRover";
	}

	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "/images/BumbleBee.jpg";
	}

}
