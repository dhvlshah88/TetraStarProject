/**
 * 
 */
package Tetra.Base;

import Tetra.Position;


/**
 * @author Dhaval
 *
 */
public class River extends Base {

	/*
	 * Default Constructor.
	 */
	public River(){
		
	}
	
	/*
	 * 
	 */
	public River(Position basePosition) {
		super(basePosition);
	}
	
	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#baseType()
	 */
	public String baseType(){
		return "River";
	}
	
	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#getImageFilePath()
	 */
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
