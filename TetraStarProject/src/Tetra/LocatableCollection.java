/**
 * 
 */
package Tetra;

import java.util.HashMap;

import Tetra.Inhabitant.TRovers;

/**
 * @author Dhaval
 *
 */
public class LocatableCollection {

	private HashMap<Position, ILocatable> inhabitantCollection = null;

	public LocatableCollection(){
		inhabitantCollection = new HashMap<Position, ILocatable>();
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

		return inhabitantCollection.get(nextPosition) != null;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position acquired by the tetra inhabitant, given inhabitantPositionCollection i.e. Hash Map 
	 * does not contains same position instance. On successful adding of the position, method returns true value. 
	 */
	public boolean addLocatableObject(ILocatable currentLocatable) {
		Position ilocatablePosition = currentLocatable.getPosition();

		if(this.objectAt(ilocatablePosition) && !(currentLocatable instanceof TRovers)){
			return false;
		}

		inhabitantCollection.put(ilocatablePosition, currentLocatable);
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

		
		/*if(!this.addIlocatableObject(ilocatableInstance)){
			((TRovers) ilocatableInstance).setPosition(currentPosition);
			return false;
		}*/
		inhabitantCollection.put(nextPosition, locatableInstance);
		inhabitantCollection.remove(currentPosition);
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

		return inhabitantCollection.get(nextPosition);
	}

}
