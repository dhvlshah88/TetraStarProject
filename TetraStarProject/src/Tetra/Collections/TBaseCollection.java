package Tetra.Collections;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TetraGUIManager;
import Tetra.Base.Base;

public class TBaseCollection extends Observable {

	private HashMap<Position, ILocatable> tbaseCollection;
	private boolean isPresent = false;
	
	/**
	 * Default Constructor
	 */
	public TBaseCollection(TetraGUIManager guiMngr){
		tbaseCollection =  new HashMap<Position, ILocatable>();
		addObserver(guiMngr);
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

		isPresent = tbaseCollection.get(nextPosition) != null;
		if(isPresent){
			setChanged();
			notifyObservers(nextPosition);
		}
		
		return isPresent;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position of any base on Tface environment. On successful adding of the position, 
	 * method returns true value. 
	 */
	public boolean addLocatableObject(ILocatable currentLocatable) {
		if(!(currentLocatable instanceof Base)){
			return false;
		}
		
		Position ilocatablePosition = currentLocatable.getPosition();

		if(this.objectAt(ilocatablePosition)){
			return false;
		}

		tbaseCollection.put(ilocatablePosition, currentLocatable);
		locatableChanged(currentLocatable);
		return true;
	}

	public HashMap<Position, ILocatable> getLocatable(){
		return tbaseCollection;
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

		return tbaseCollection.get(nextPosition);
	}
	

	/**
	 * This method update inhabitantPositionCollection object i.e. Hash Map by the next valid position of the inhabitant.
	 * This method removes the old position it contained and updates with new. On successful updation of the position, 
	 * method returns true value.
	 * @return {@link Boolean}
	 */
	public boolean changePosition(Position currentPosition, Position nextPosition) {
		return false;
	}
	
	
	public void removeLocatableAtPosition(Position nextPosition){
	}
	
	public void locatableChanged(ILocatable locatableObj){
		setChanged();
		notifyObservers(locatableObj);
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}
	
}
