/**
 * 
 */
package Tetra.Inhabitant;

import java.util.ArrayList;

import Tetra.ILocatable;
import Tetra.TetraGUIManager;
import Tetra.Position;
import Tetra.Base.MapBase;
import Tetra.Base.TVaderBase;
import Tetra.Collections.TBaseCollection;
import Tetra.Collections.TInhabitantCollection;
import Tetra.Inhabitant.Vehicle.Vehicle;
import Tetra.Map.Map;


/**
 * @author Dhaval
 *
 */
public class TVader extends TRovers {

	private ArrayList<Position> positionList = null;
	private Map stolenMap = null;
	private Vehicle vehicle = null;
	private TInhabitantCollection inhabitantColl = null;
	private static int length;
	private boolean traceOn = true;
	private TBaseCollection tbaseColl;
	private ILocatable locatableObj;
	private Position nextPosition; 
	private static TVader instance = null;


	private TVader(Position currentPosition){
		super(currentPosition);
		positionList = new ArrayList<Position>();
		recordMove(currentPosition);
	}
	
	public static TVader getInstance(Position position){
		if(instance == null){
			instance = new TVader(position);
		}
		
		return instance;
	}

	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		this.setMovementStrategy(vehicle.getMovementStrategy());
	}

	public Vehicle getVehicle(){
		return vehicle;
	}

	public void stealMap(MapBase base){
		if(!base.isMapPresent()){
			return;
		}
		this.stolenMap = base.removeMap();
		stolenMap.setEncrypted(false);
		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has decrypted the map.");
		
	}

	public void moveToPosition(Position nextPosition){
		inhabitantColl = super.getInhabitantColl();	
		if(inhabitantColl.objectAt(nextPosition)){
			TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") cannot move to Location (" 
					+ nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ") as ");
			TetraGUIManager.DisplaySteps(((TRovers)inhabitantColl.getLocatableAtPosition(nextPosition)).getType() + " present at that location!!");
			return;
		}

		tbaseColl = super.getBaseColl();
		if(tbaseColl.objectAt(nextPosition)){
			locatableObj = tbaseColl.getLocatableAtPosition(nextPosition);

			if(locatableObj instanceof TVaderBase){

				inhabitantColl.changePosition(this.getPosition(), nextPosition);
				this.setPosition(nextPosition);
				TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				enterVaderBase(locatableObj);
				return;
			}

			if(locatableObj instanceof MapBase){
				if(traceOn){
					inhabitantColl.changePosition(this.getPosition(), nextPosition);
					this.setPosition(nextPosition);
					TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
				}
				enterMapBase(locatableObj);
				return;
			}

			TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has cannot moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
			return;
		}


		inhabitantColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);

		if(traceOn){
			recordMove(nextPosition);
			TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has moved to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");			
		}
	}

	public void recordMove(Position positionCovered){
		positionList.add(positionCovered);
	}

	public void retracePosition(){
		traceOn = false;
		length = positionList.size();

		if(length < 0){
			traceOn = true;
			return;
		}
		length--;
		nextPosition = positionList.remove(length);
		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") retracing to Location (" + nextPosition.getRowNo() + ", " + nextPosition.getColumnNo() + ")");
		moveToPosition(nextPosition);
	}

	public void enterMapBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has entered map base searching for map.");
		MapBase mapBase = (MapBase) locatableObj;
		if(!mapBase.isMapPresent()){
			TetraGUIManager.DisplaySteps("Map not found there");
			return;
		}

		stealMap(mapBase);

		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has stolen map (ID: " + mapBase.getMapId() + ").");
	}

	public void enterVaderBase(ILocatable locatableObj){
		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has entered his base.");
		TVaderBase vaderBase = (TVaderBase) locatableObj;
		vaderBase.setMap(stolenMap);
		TetraGUIManager.DisplaySteps("TVader " + getName() + " (ID: " + getTetId() + ") has stored stolen map (ID: " + stolenMap.getMapId() + ").");
	}

	public String getType(){
		return "TVader";
	}

	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "/images/Megatron.jpg";
	}
}
