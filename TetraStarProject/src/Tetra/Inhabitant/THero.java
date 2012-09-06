/**
 * 
 */
package Tetra.Inhabitant;

import java.text.SimpleDateFormat;
import java.util.Date;

import Tetra.ILocatable;
import Tetra.TetraGUIManager;
import Tetra.Position;
import Tetra.Base.MapBase;
import Tetra.Base.THeroBase;
import Tetra.Base.TVaderBase;
import Tetra.Collections.TBaseCollection;
import Tetra.Collections.TInhabitantCollection;
import Tetra.Collections.VehicleCollection;
import Tetra.Inhabitant.Vehicle.Vehicle;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.IEncryptionStrategy;
import Tetra.Map.Map;
import Tetra.Map.StarMap;
import Tetra.Map.StarSignal;
import TetraGUI.MapViewFactory;

/**
 * @author Dhaval
 *
 */
public class THero extends TRovers {

	private IEncryptionStrategy eStrategy;
	private Map map;
	private Map clonedMap;
	private boolean mapPresent = false;
	private boolean clonedMapPresent = false;
	private String mapId = null;
	private boolean mapStolen = false;
	private String symbol = "*";
	private Date dateNow;
	private SimpleDateFormat dateformatter;
	private TInhabitantCollection inhabitantColl = null;
	private TBaseCollection tbaseColl = null;
	private VehicleCollection vehicleColl = null;
	private Position nextPosition = null;
	private ILocatable locatableObj = null;
	private Vehicle vehicle = null;

	/**
	 * Default Constructor 
	 */
	public THero(){

	}

	public THero(Position currentPosition){
		super(currentPosition);
	}

	public void setMap(Map map){
		if(map != null && !mapPresent){
			this.map = map;
			this.mapId = map.getMapId();
			mapPresent = true;
		}
	}

	public Map getMap(){
		return map;
	}

	public String getMapId(){
		return mapId;
	}

	public void setEncryptionStrategy(IEncryptionStrategy eStrategy){
		this.eStrategy = eStrategy;
	}

	public IEncryptionStrategy getEncryptionStrategy(){
		return eStrategy;
	}

	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle(){
		return vehicle;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public Map encryptMap(Map map){
		if(map instanceof StarMap && !mapPresent){
			dateNow = new Date();
			dateformatter = new SimpleDateFormat("MMM dd yyyy");
			this.map = new EncryptedStarMap(map, getEncryptionStrategy(), getTetId(), dateformatter.format(dateNow), map.getRestorationCounter() + 1, this.symbol);
			this.map.setEncrypted(true);
		}

		if(map instanceof EncryptedStarMap && !map.isEncrypted()){
			map.setEncrypted(true);
		}
		return this.map;
	}

	public Map decryptMap(Map map){
		map.setEncrypted(false);
		return map;
	}

	public Map returnMap(){
		if(!mapPresent){
			return null;
		}

		Map tempMap;
		tempMap = map;
		map = null;
		mapId = null;
		mapPresent = false;
		return tempMap;
	}

	public Map returnClonedMap(){
		TetraGUIManager.DisplaySteps("THero " + this.getTetId() + " returns cloned map in hero base.");	
		Map tempMap;
		tempMap = clonedMap;
		clonedMap = null;
		return tempMap;
	}

	public void cloneMap(Map map) throws CloneNotSupportedException{
		this.clonedMap = map.clone();
		clonedMapPresent = true;
	}

	public boolean isMapPresent(){
		return mapPresent;
	}

	public boolean isCloneMapPresent(){
		return clonedMapPresent;
	}

	public ILocatable validatePosition(Position nextPosition){

		inhabitantColl = super.getInhabitantColl();
		if(inhabitantColl.objectAt(nextPosition)){
			locatableObj = inhabitantColl.getLocatableAtPosition(nextPosition);
			return locatableObj;		
		}
		
		tbaseColl = super.getBaseColl();
		if(tbaseColl.objectAt(nextPosition)){
			locatableObj = tbaseColl.getLocatableAtPosition(nextPosition);
			return locatableObj;
		}

		vehicleColl = super.getVehicleColl();
		if(vehicleColl.objectAt(nextPosition)){
			locatableObj = vehicleColl.getLocatableAtPosition(nextPosition);
			return locatableObj;
		}
		
		return null;
	}
	
	public void moveAStep(Position nextPosition){
		inhabitantColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
	}

	public void moveToPosition(Position nextPosition){

		if(vehicle != null && mapStolen){
			flyToVaderBase();
			mapStolen = false;
		}

		inhabitantColl = super.getInhabitantColl();	
		if(inhabitantColl.objectAt(nextPosition)){
			TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") cannot move to Location (" 
					+ nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ") as ");
			TetraGUIManager.DisplaySteps(((TRovers)inhabitantColl.getLocatableAtPosition(nextPosition)).getType() + " present at that location!!");
			return;
		}

		tbaseColl = super.getBaseColl();
		if(tbaseColl.objectAt(nextPosition)){
			locatableObj = tbaseColl.getLocatableAtPosition(nextPosition);

			if(locatableObj instanceof THeroBase){
				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				enterHeroBase(locatableObj);
				return;
			}

			if(locatableObj instanceof TVaderBase){
				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				enterVaderBase(locatableObj);
				return;
			}

			if(locatableObj instanceof MapBase){
				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				enterMapBase(locatableObj);
				return;
			}
			TetraGUIManager.DisplaySteps("TRover " + getName() + " (ID: " + getTetId() + ") has cannot moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
			return;
		}

		vehicleColl = super.getVehicleColl();
		if(vehicleColl.objectAt(nextPosition)){
			if(mapStolen){
				locatableObj = vehicleColl.getLocatableAtPosition(nextPosition);
				vehicleColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				setVehicle((Vehicle)locatableObj);
			}
			return;
		}

		inhabitantColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
	}

	public void enterHeroBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") enters hero base.");	

		THeroBase heroBase = (THeroBase) locatableObj;
		if(clonedMapPresent){
			heroBase.addMap(returnClonedMap());
			displayMap(heroBase.getCloneMap());
		}
	}

	public void enterMapBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") enters map base.");

		MapBase mapBase = (MapBase) locatableObj;
		if(mapBase.isMapPresent()){
			Map map = mapBase.getMap();
			TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") found the map " + map.getMapId() + ".");

			if(map.isEncrypted()){
				if(((EncryptedStarMap) map).getTHeroId().equals(super.getTetId())){
					TetraGUIManager.DisplaySteps("Map is encrypted by him.");
					decryptMap(map);
					TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has decrypted map.");
					displayMap(map);
					TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") now display's decrypted map.");
					encryptMap(map);
					TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") has encrypted map.");
					displayMap(map);
					TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") now display's encrypted map.");
				}
				else{
					TetraGUIManager.DisplaySteps("Map is encrypted by other hero (" + map.getTHeroId() + ")");
					map = new EncryptedStarMap(map, null, getTetId(), map.getEncryptionDate(), 0, this.symbol);
					displayMap(map);
				}
			}else{
				this.displayMap(map);
			}
		}
		else{
			if(this.mapId != mapBase.getMapId()){
				TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") couldn't find the map " + mapBase.getMapId() + ".");
				TetraGUIManager.DisplaySteps("TVader has stolen it.");
				mapStolen = true;
				this.mapId = mapBase.getMapId();
				return;
			}

			mapBase.setMap(returnMap());
			TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") returned encrypted map in map base.");

		}
		locatableObj.getPosition();
	}

	public void enterVaderBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") enters vader base.");

		TVaderBase vaderBase = (TVaderBase)locatableObj;
		if(!vaderBase.isMapPresent()){
			return;
		}

		TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") signals the stolen map for it's presence.");

		StarSignal signal = vaderBase.getMap().showSignal(mapId);


		if(!signal.isMapIdentical()){
			return;
		}
		else{
			TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") got green signal!!");

			this.map = vaderBase.removeMap();

			TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") found decrypted map (ID:" + map.getMapId() + ").");

			try {
				this.cloneMap(map);
				TetraGUIManager.DisplaySteps("THero " + getName() + " (ID: " + getTetId() + ") clone's map!!");	
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			displayMap(encryptMap(map));
			mapStolen = false;
			mapPresent = true;
		}

	}

	public void flyToVaderBase(){
		nextPosition = super.getVaderBasePosition();
		inhabitantColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		vehicleColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		locatableObj = inhabitantColl.getLocatableAtPosition(nextPosition);
		enterVaderBase(locatableObj);
	}

	@Override
	public String getType() {
		return "THero";
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getImageFilePath(){
		return "/images/Optimus.png";
	}
	
	
	public void sleep(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
