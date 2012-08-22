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

	public River(){
		
	}
	
	public River(Position basePosition) {
		super(basePosition);
	}
	
	public String baseType(){
		return "River";
	}
	
	@Override
	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
