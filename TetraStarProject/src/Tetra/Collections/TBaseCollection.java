package Tetra.Collections;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TetraGUIManager;
import Tetra.Base.Base;

public class TBaseCollection extends Observable {
	
	
	private static TBaseCollection instance = null;
	private HashMap<Position, ILocatable> tbaseCollection;
	private boolean isPresent = false;
	
	/**
	 * Default Constructor
	 */
	private TBaseCollection(TetraGUIManager guiMngr){
		tbaseCollection =  new HashMap<Position, ILocatable>();
		super.addObserver(guiMngr);
	}
	
	public static TBaseCollection getInstance(TetraGUIManager guiMngr){
		if(instance == null) {
			instance = new TBaseCollection(guiMngr);
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

	public HashMap<Position, ILocatable> getCollection(){
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
	
	
	public void locatableChanged(ILocatable locatableObj){
		setChanged();
		notifyObservers(locatableObj);
	}
	
}
