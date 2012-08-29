package Tetra;

import java.util.HashMap;

import Tetra.Inhabitant.TRovers;
import Tetra.Inhabitant.Vehicle.Vehicle;

public class VehicleCollection {
	
	private HashMap<Position, ILocatable> vehicleCollection = null;

	public VehicleCollection(){
		vehicleCollection = new HashMap<Position, ILocatable>();
	}

	/**
	 * This method checks whether the next position provided by the movement strategy to TRover, THero and TVader is 
	 * already acquired by any one else.
	 * @return {@link Boolean}
	 */
	public boolean objectAt(Position nextPosition) {

		if(nextPosition == null){
			return false;
		}

		return vehicleCollection.get(nextPosition) != null;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position acquired by the tetra inhabitant, given inhabitantPositionCollection i.e. Hash Map 
	 * does not contains same position instance. On successful adding of the position, method returns true value. 
	 */
	public boolean addLocatableObject(ILocatable currentLocatable) {
		if(!(currentLocatable instanceof Vehicle)){
			return false;
		}
		
		Position ilocatablePosition = currentLocatable.getPosition();

		if(this.objectAt(ilocatablePosition)){
			return false;
		}

		vehicleCollection.put(ilocatablePosition, currentLocatable);
		//locatableChanged(currentLocatable);
		return true;
	}

	/**
	 * This method update inhabitantPositionCollection object i.e. Hash Map by the next valid position of the inhabitant.
	 * This method removes the old position it contained and updates with new. On successful updation of the position, 
	 * method returns true value.
	 * @return {@link Boolean}
	 */
	public boolean changePosition(Position currentPosition, Position nextPosition) {
		if(currentPosition == null || nextPosition == null){
			return false;
		}

		ILocatable locatableInstance = this.getLocatableAtPosition(currentPosition);
		((TRovers) locatableInstance).setPosition(nextPosition);

		
		vehicleCollection.put(nextPosition, locatableInstance);
		vehicleCollection.remove(currentPosition);
		//locatableChanged(locatableInstance);
		return true;	
	}

	/**
	 * 
	 * @param nextPosition
	 * @return
	 */
	public ILocatable getLocatableAtPosition(Position nextPosition) {
		if(nextPosition == null){
			return null;
		}

		return vehicleCollection.get(nextPosition);
	}
	
	
	public HashMap<Position, ILocatable> getLocatable(){
		return vehicleCollection;
	}
	
	public void removeLocatableAtPosition(Position nextPosition){
		if(nextPosition == null){
			return;
		}
		
		vehicleCollection.remove(nextPosition);
		//locatableChanged(null);
	}
	
	/*public void locatableChanged(ILocatable locatableObj){
		setChanged();
		notifyObservers(locatableObj);
	}*/

}
