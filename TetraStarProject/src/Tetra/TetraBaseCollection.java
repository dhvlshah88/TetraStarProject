/**
 * 
 */
package Tetra;

import java.util.HashMap;

import Tetra.Base.Base;

/**
 * @author Dhaval
 *
 */
public class TetraBaseCollection implements ITetraCollection {

	private HashMap<String, Base> tetraBaseCollection = null;
	private HashMap<String, Position> basePositionCollection = null;
 	private Base base = null;
	
	public TetraBaseCollection(){
		tetraBaseCollection = new HashMap<String, Base>();
		basePositionCollection = new HashMap<String, Position>();
	}

	/**
	 * @return {@link Boolean}
	 * This method checks whether the next position provided by the movement strategy to TRover, THero and TVader contains 
	 * base instance.
	 */
	@Override
	public boolean comparePosition(Position nextPosition) {

		if(nextPosition == null){
			return false;
		}

		return basePositionCollection.get(nextPosition.toString()) != null;
	}

	/**
	 * @return {@link Boolean}
	 * This method adds current position acquired by the base, given basePositionCollection i.e. Hash Map 
	 * does not contains same position instance. On successful adding of the position, method returns true value. 
	 */
	@Override
	public boolean addPosition(Position currentPosition) {
		if(this.comparePosition(currentPosition)){
			return false;
		}

		basePositionCollection.put(currentPosition.toString(), currentPosition);
		return true;
	}

	/**
	 * @return {@link Boolean}
	 * This method update basePositionCollection object i.e. Hash Map by the next valid position of the inhabitant.
	 * This method removes the old position it contained and updates with new. On successful update of the position, 
	 * method returns true value.
	 */
	@Override
	public boolean changePosition(Position currentPosition, Position nextPosition) {
		if(currentPosition == null || nextPosition == null){
			return false;
		}

		this.addPosition(nextPosition);
		basePositionCollection.remove(currentPosition.toString());
		return false;	
	}

	public boolean addBase(Base base){
		
		if(base == null){
			return false;
		}
		
		Position basePosition = base.getPosition();
		if(!this.addPosition(basePosition)){
			return false;
		}
		
		tetraBaseCollection.put(basePosition.toString(), base);
		return true;
	}

	public Base getBaseAtPosition(Position nextPosition){
		if(nextPosition == null || tetraBaseCollection.isEmpty()){
			return null;
		}
		
		base = tetraBaseCollection.get(nextPosition.toString());
		return base;
	}

}
