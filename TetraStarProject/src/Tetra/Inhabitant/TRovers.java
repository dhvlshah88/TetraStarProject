package Tetra.Inhabitant;

import Tetra.ILocatable;
import Tetra.TBaseCollection;
import Tetra.TInhabitantCollection;
import Tetra.Logger;
import Tetra.Position;
import Tetra.TFace;
import Tetra.VehicleCollection;
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
	private Position previousPosition = null;
	private Position vaderBasePosition = null;
	private TFace tface;
	private IMovementStrategy movementStrategy = null;
	private TInhabitantCollection inhabitantColl = null;
	private TBaseCollection baseColl = null;
	private VehicleCollection vehicleColl = null;
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
	 * @param currentPosition
	 */
	public void setPrevPosition(Position previousPosition) {
		this.previousPosition = previousPosition;
	}

	/**
	 * @return
	 */
	public Position getPrevPosition() {
		return previousPosition;
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

	public void setInhabitantColl(TInhabitantCollection inhabitantColl) {
		this.inhabitantColl = inhabitantColl;
	}
	
	public TInhabitantCollection getInhabitantColl() {
		return inhabitantColl;
	}
	
	public void setBaseColl(TBaseCollection baseColl) {
		this.baseColl = baseColl;
	}
	
	public TBaseCollection getBaseColl() {
		return baseColl;
	}
	
	public void setVehicleColl(VehicleCollection vehicleColl) {
		this.vehicleColl = vehicleColl;
	}
	
	public VehicleCollection getVehicleColl() {
		return vehicleColl;
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
			starMapView.setVisible(true);
		}else{
			StarAtlasView starAtlasView = new StarAtlasView();
			starAtlasView.setStarAtlas((StarAtlas)map);
			starAtlasView.setVisible(true);
			}
	}


	/*public void moveToPosition(){
		nextPosition = this.getMovementStrategy().getNewPosition(this.getPosition());
		moveToPosition(nextPosition);
	}*/

	public void moveToPosition(Position nextPosition){
	
		if(inhabitantColl.objectAt(nextPosition)){
			locatableObj = inhabitantColl.getLocatableAtPosition(nextPosition);
			if(locatableObj instanceof TRovers){
				return;
			}
			return;
		}
		
		if(baseColl.objectAt(nextPosition)){
			locatableObj = baseColl.getLocatableAtPosition(nextPosition);
			if(locatableObj instanceof River || locatableObj instanceof THeroBase || locatableObj instanceof TVaderBase){
				return;
			}else{
				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				this.enterMapBase(locatableObj);
			}
			return;
		}
		
		if(vehicleColl.objectAt(nextPosition)){
			locatableObj = vehicleColl.getLocatableAtPosition(nextPosition);
			return;
		}

		inhabitantColl.changePosition(this.getPosition(), nextPosition);
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
