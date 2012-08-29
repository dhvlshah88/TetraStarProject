package Tetra;

import java.util.HashMap;

import Tetra.Base.Base;

public class TBaseCollection {

	private HashMap<Position, ILocatable> tbaseCollection = null;

	/**
	 * Default Constructor
	 */
	public TBaseCollection(){
		tbaseCollection = new HashMap<Position, ILocatable>();
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

		return tbaseCollection.get(nextPosition) != null;
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
	

	
}
