package Tetra.Inhabitant;

import Tetra.ILocatable;
import Tetra.TetraGUIManager;
import Tetra.Position;
import Tetra.Base.MapBase;
import Tetra.Base.TVaderBase;
import Tetra.Collections.TBaseCollection;
import Tetra.Collections.TInhabitantCollection;
import Tetra.Collections.VehicleCollection;
import Tetra.Inhabitant.Movement.IMovementStrategy;
import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import TetraGUI.MapViewFactory;
import TetraGUI.StarAtlasView;
import TetraGUI.StarMapView;


public class TRovers implements ILocatable {

	private String gender = null;
	private String tetId = null;
	private String name = null;
	private Position currentPosition = null;
	private Position previousPosition = null;
	private Position vaderBasePosition = null;
	private Position nextPosition = null;
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
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") is display map (ID:" + map.getMapId() + ").");
		MapViewFactory mapView = new MapViewFactory();
		mapView.createMapView(map);
	}

	public void moveToPosition(){
		nextPosition = this.getMovementStrategy().getNewPosition(this.getPosition());
		moveToPosition(nextPosition);
	}

	public void moveToPosition(Position nextPosition){

		if(inhabitantColl.objectAt(nextPosition)){
			TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ") cannot move to Location (" 
					+ nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ") as ");
			TetraGUIManager.DisplaySteps(((TRovers)inhabitantColl.getLocatableAtPosition(nextPosition)).getType() + " present at that location!!");
			return;
		}

		if(baseColl.objectAt(nextPosition)){
			locatableObj = baseColl.getLocatableAtPosition(nextPosition);
			if(locatableObj instanceof MapBase){
				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ")  moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				this.enterMapBase(locatableObj);
				return;
			}

			TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ")  cannot moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
			return;
		}

		if(vehicleColl.objectAt(nextPosition)){
			locatableObj = vehicleColl.getLocatableAtPosition(nextPosition);
			return;
		}

		inhabitantColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ")  moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
	}

	public void enterMapBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("TRover " + this.getTetId() + " enters map base.");

		MapBase mapBase = (MapBase) locatableObj;
		if(mapBase.isMapPresent()){
			Map map = mapBase.getMap();
			TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ") found the map " + map.getMapId() + ".");
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
