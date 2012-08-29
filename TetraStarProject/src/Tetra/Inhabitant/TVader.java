/**
 * 
 */
package Tetra.Inhabitant;

import java.util.ArrayList;

import Tetra.TInhabitantCollection;
import Tetra.Position;
import Tetra.Base.MapBase;
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
	private TInhabitantCollection locatableColl = null;
	private static int length;
	
	/*
	 * Default Constructor 
	 */
	public TVader(){

	}

	public TVader(Position currentPosition){
		super(currentPosition);
		positionList = new ArrayList<Position>();
		locatableColl = new TInhabitantCollection();
	}

	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		this.setMovementStrategy(vehicle.getMovementStrategy());
	}

	public Vehicle getVehicle(){
		return vehicle;
	}
	
	public boolean stealMap(MapBase base){
		if(!base.isMapPresent()){
			return false;
		}
		this.stolenMap = base.removeMap();
		return true;
	}

	public void moveToPosition(Position nextPosition){
		locatableColl.changePosition(this.getPosition(), nextPosition);
		this.setPosition(nextPosition);
		recordMove(nextPosition);
	}
	
	public void recordMove(Position positionCovered){
		positionList.add(positionCovered);
	}
	
	public void retracePosition(){
		length = positionList.size();
		moveToPosition(positionList.remove(length--));
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
