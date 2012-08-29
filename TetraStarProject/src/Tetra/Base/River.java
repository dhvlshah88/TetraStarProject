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
	public String getType(){
		return "River";
	}
	
	/**
	 * 
	 */
	@Override
	public String getImageFilePath() {
		return "/images/River.jpg";
	}
}
