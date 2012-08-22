/**
 * 
 */
package Tetra.Base;

import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public abstract class Base {

	private Position basePosition = null;
	
	public Base(){
		
	}
	
	public Base(Position basePosition){
		this.basePosition = basePosition;
	}
	
	public void setBasePosition(Position basePosition){
		this.basePosition = basePosition;
	}
	
	public Position getBasePosition(){
		return basePosition;
	}


	public abstract String baseType();
	public abstract String getImageFilePath();
	
	
	
}
