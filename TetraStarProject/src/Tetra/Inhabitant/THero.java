/**
 * 
 */
package Tetra.Inhabitant;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import Tetra.ILocatable;
import Tetra.TInhabitantCollection;
import Tetra.Logger;
import Tetra.Position;
import Tetra.StarSignal;
import Tetra.Base.MapBase;
import Tetra.Base.River;
import Tetra.Base.THeroBase;
import Tetra.Base.TVaderBase;
import Tetra.Inhabitant.Vehicle.Vehicle;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.IEncrytionStrategy;
import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import Tetra.Map.StarMap;
import TetraGUI.StarAtlasView;
import TetraGUI.StarMapView;


/**
 * @author Dhaval
 *
 */
public class THero extends TRovers {

	private IEncrytionStrategy eStrategy;
	private Map map;
	private Map clonedMap;
	private boolean mapPresent = false;
	private boolean clonedMapPresent = false;
	private String mapId = null;
	private boolean isBase = false;
	private boolean mapStolen = false;
	private String symbol = "*";
	private Date dateNow;
	private SimpleDateFormat dateformatter;
	private TInhabitantCollection locatableColl = null;
	private Position nextPosition = null;
	private ILocatable locatableObj = null;
	private Position lastVisitedMapBasePosition = null; 
	private boolean requestVehicle = false;
	private Vehicle vehicle = null;

	/**
	 * Default Constructor 
	 */
	public THero(){

	}

	public THero(Position currentPosition){
		super(currentPosition);
		locatableColl = new TInhabitantCollection();
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

	public void setEncryptionStrategy(IEncrytionStrategy eStrategy){
		this.eStrategy = eStrategy;
	}

	public IEncrytionStrategy getEncryptionStrategy(){
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
		Logger.DisplaySteps("THero " + this.getTetId() + " returns cloned map in hero base.");	
		Map tempMap;
		tempMap = clonedMap;
		clonedMap = null;
		return tempMap;
	}

	public void cloneMap(Map map) throws CloneNotSupportedException{
		this.clonedMap = map.clone();
		clonedMapPresent = true;
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
	
	public boolean isMapPresent(){
		return mapPresent;
	}

	public boolean isCloneMapPresent(){
		return clonedMapPresent;
	}

	public void moveToPosition(Position nextPosition){
		locatableColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
	}

	/*public void moveToPosition(Position nextPosition){
		if(!isBase && !mapStolen && !clonedMapPresent){
			if(locatableColl.objectAt(nextPosition)){
				
				locatableObj = locatableColl.getLocatableAtPosition(nextPosition);

				if(locatableObj instanceof TRovers){
					return;
				}

				if(locatableObj instanceof River){
					return;
				}else if(locatableObj instanceof THeroBase){
					isBase = true;
				}else if(locatableObj instanceof MapBase){
					isBase = true;
				}else if(locatableObj instanceof TVaderBase){
					isBase = true;
				}

				if(locatableObj instanceof Vehicle){
					if(requestVehicle){
						Vehicle vehicle = ((Vehicle) locatableObj);
						if(!vehicle.isPossessed()){
							this.setVehicle(vehicle);
							locatableColl.removeLocatableAtPosition(nextPosition);
							requestVehicle = false;
						}
						return;
					}
				}
			}
		}else if(isBase){
			if(locatableObj instanceof THeroBase){
				enterHeroBase(locatableObj);
			}else if(locatableObj instanceof MapBase){
				enterMapBase(locatableObj);
			}else if(locatableObj instanceof TVaderBase){
				enterVaderBase(locatableObj);
			}
			isBase = false;
			return;
		}else if(clonedMapPresent){
			nextPosition = lastVisitedMapBasePosition;
			isBase = true;
		}

		locatableColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);

	}*/

	/*
	public void setPresentInBase(boolean presentInBase){
		this.presentInBase = presentInBase;
	}

	public boolean presentInBase(){
		return presentInBase;
	}*/

	public void enterHeroBase(ILocatable locatableObj){
		Logger.DisplaySteps("THero " + this.getTetId() + " enters hero base.");	

		THeroBase heroBase = (THeroBase) locatableObj;
		if(clonedMapPresent){
			heroBase.addMap(this.returnClonedMap());
		}
	}

	
	public void enterMapBase(ILocatable locatableObj){
		Logger.DisplaySteps("THero " + this.getTetId() + " enters map base.");

		MapBase mapBase = (MapBase) locatableObj;
		if(mapBase.isMapPresent()){
			Map map = mapBase.getMap();
			Logger.DisplaySteps("THero " + this.getTetId() + " found the map " + map.getMapId() + ".");
			
			if(map.isEncrypted()){
				if(((EncryptedStarMap) map).getTHeroId() == super.getTetId()){
					Logger.DisplaySteps("Map is encrypted by him.");
					decryptMap(map);
					Logger.DisplaySteps("THero " + this.getTetId() + " decrypt's map.");
					displayMap(map);
					Logger.DisplaySteps("THero " + this.getTetId() + " display's map.");
					encryptMap(map);
					Logger.DisplaySteps("THero " + this.getTetId() + " encrypt's map.");
				}
				else{
					Logger.DisplaySteps("Map is encrypted by other hero (" + map.getTHeroId() + ")");
					map = new EncryptedStarMap(map, null, getTetId(), map.getEncryptionDate(), 0, this.symbol);
					displayMap(map);
				}
			}else{
				this.displayMap(map);
			}
		}
		else{
			if(this.mapId != mapBase.getMapId()){
				mapStolen = true;
				this.mapId = mapBase.getMapId();
				requestVehicle = true;
				return;
			}

			mapBase.setMap(this.returnMap());
		}
		this.lastVisitedMapBasePosition = locatableObj.getPosition();
	}

	public void enterVaderBase(ILocatable locatableObj){
		TVaderBase vaderBase = (TVaderBase)locatableObj;
		if(!vaderBase.isMapPresent()){
			return;
		}
		StarSignal signal = vaderBase.getMap().showSignal(mapId);

		if(!signal.isMapIdentical()){
			return;
		}
		else{
			this.map = vaderBase.removeMap();
			try {
				this.cloneMap(map);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			this.encryptMap(map);
			mapStolen = false;
		}

	}

	@Override
	public String getType() {
		return "THero";
	}

	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "/images/Optimus.png";
	}
}
