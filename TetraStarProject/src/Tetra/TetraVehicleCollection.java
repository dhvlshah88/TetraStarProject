/**
 * 
 */
package Tetra;

import java.util.HashMap;

import Tetra.Base.Base;
import Tetra.Inhabitant.Vehicle.Vehicle;

/**
 * @author Dhaval
 *
 */
public class TetraVehicleCollection implements ITetraCollection {
	
	private HashMap<String, Vehicle> tetraVehicleCollection = null;
	private HashMap<String, Position> vehiclePositionCollection = null;
 	//private Vehicle base = null;
	
	public TetraVehicleCollection(){
		tetraVehicleCollection = new HashMap<String, Vehicle>();
		vehiclePositionCollection = new HashMap<String, Position>();
	}

	/**
	 * @return {@link Boolean}
	 * This method checks whether the next position provided by the movement strategy to TRover, THero and TVader contains 
	 * vehicle instance.
	 */
	@Override
	public boolean comparePosition(Position nextPosition) {

		if(nextPosition == null){
			return false;
		}

		return vehiclePositionCollection.get(nextPosition.toString()) != null;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position acquired by the vehicle, given vehiclePositionCollection i.e. Hash Map 
	 * does not contains same position instance. On successful adding of the position, method returns true value. 
	 */
	@Override
	public boolean addPosition(Position currentPosition) {
		if(this.comparePosition(currentPosition)){
			return false;
		}

		vehiclePositionCollection.put(currentPosition.toString(), currentPosition);
		return true;
	}

	/**
	 * @return {@link Boolean}
	 * This method update vehiclePositionCollection object i.e. Hash Map by the next valid position of the inhabitant.
	 * This method removes the old position it contained and updates with new. On successful update of the position, 
	 * method returns true value.
	 */
	@Override
	public boolean changePosition(Position currentPosition, Position nextPosition) {
		if(currentPosition == null || nextPosition == null){
			return false;
		}

		this.addPosition(nextPosition);
		vehiclePositionCollection.remove(currentPosition.toString());
		return false;	
	}

	public boolean addVehicle(Vehicle vehicle){
		
		if(vehicle == null){
			return false;
		}
		
		Position vehiclePosition = vehicle.getPosition();
		if(!this.addPosition(vehiclePosition)){
			return false;
		}
		
		tetraVehicleCollection.put(vehiclePosition.toString(), vehicle);
		return true;
	}

	public Vehicle getVehicleAtPosition(Position nextPosition){
		if(nextPosition == null || tetraVehicleCollection.isEmpty()){
			return null;
		}
		
		return tetraVehicleCollection.get(nextPosition.toString());
	}

}
