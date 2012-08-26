/**
 * 
 */
package Tetra;

import java.util.HashMap;
import java.util.Observable;

/**
 * @author Dhaval
 *
 */
public class TetraInhabitantCollection extends Observable implements ITetraCollection   {

	private HashMap<String, Position> inhabitantPositionCollection = null;
	
	public TetraInhabitantCollection(){
		inhabitantPositionCollection = new HashMap<String, Position>();
	}
	
	/**
	 * @return {@link Boolean}
	 * This method checks whether the next position provided by the movement strategy to TRover, THero and TVader is 
	 * already acquired by any one else.
	 */
	@Override
	public boolean comparePosition(Position nextPosition) {
		
		if(nextPosition == null){
			return false;
		}
	
		return inhabitantPositionCollection.get(nextPosition.toString()) != null;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position acquired by the tetra inhabitant, given inhabitantPositionCollection i.e. Hash Map 
	 * does not contains same position instance. On successful adding of the position, method returns true value. 
	 */
	@Override
	public boolean addPosition(Position currentPosition) {
		if(this.comparePosition(currentPosition)){
			return false;
		}
		
		inhabitantPositionCollection.put(currentPosition.toString(), currentPosition);
		return true;
	}

	/**
	 * @return {@link Boolean}
	 * This method update inhabitantPositionCollection object i.e. Hash Map by the next valid position of the inhabitant.
	 * This method removes the old position it contained and updates with new. On successful updation of the position, 
	 * method returns true value.
	 */
	@Override
	public boolean changePosition(Position currentPosition, Position nextPosition) {
		if(currentPosition == null || nextPosition == null){
			return false;
		}
		
		this.addPosition(nextPosition);
		inhabitantPositionCollection.remove(currentPosition.toString());
		return false;	
	}
	
	

}
