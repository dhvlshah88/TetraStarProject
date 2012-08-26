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

	/**
	 * Default Constructor.
	 */
	public River(){
		
	}
	
	/**
	 * 
	 */
	public River(Position basePosition) {
		super(basePosition, "R");
	}
	
	/**
	 * 
	 */
	public String baseType(){
		return "River";
	}
	
	/**
	 * 
	 */
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
