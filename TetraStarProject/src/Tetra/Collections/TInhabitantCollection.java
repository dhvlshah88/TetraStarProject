/**
 * 
 */
package Tetra.Collections;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TetraGUIManager;
import Tetra.Inhabitant.TRovers;

/**
 * @author Dhaval
 *
 */
public class TInhabitantCollection extends Observable{

	private static TInhabitantCollection instance = null;
	
	private HashMap<Position, ILocatable> inhabitantCollection = null;
	
	private boolean isPresent = false;

	private TInhabitantCollection(TetraGUIManager guiMngr){
		inhabitantCollection = new HashMap<Position, ILocatable>();
		super.addObserver(guiMngr);
	}

	public static TInhabitantCollection getInstance(TetraGUIManager guiMngr) {
		if(instance == null) {
			instance = new TInhabitantCollection(guiMngr);
		}
		return instance;
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

		isPresent = inhabitantCollection.get(nextPosition) != null;
		if(isPresent){
			setChanged();
			notifyObservers(nextPosition);
		}
		return isPresent;
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
		locatableChanged(currentLocatable);
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
		((TRovers) locatableInstance).setPrevPosition(currentPosition);
		((TRovers) locatableInstance).setPosition(nextPosition);
		
		inhabitantCollection.put(nextPosition, locatableInstance);
		inhabitantCollection.remove(currentPosition);
		locatableChanged(locatableInstance);
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
	
	
	public HashMap<Position, ILocatable> getCollection(){
		return inhabitantCollection;
	}
	
	/*public void removeLocatableAtPosition(Position nextPosition){
		if(nextPosition == null){
			return;
		}
		
		inhabitantCollection.remove(nextPosition);
		locatableChanged(null);
	}*/
	
	public void locatableChanged(ILocatable locatableObj){
		setChanged();
		notifyObservers(locatableObj);
	}

}
