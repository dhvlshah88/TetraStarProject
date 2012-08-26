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
	
	private String baseId = null;
	
	public Base(){
		
	}
	
	public Base(Position basePosition, String baseId){
		this.basePosition = basePosition;
		this.baseId = baseId.concat(basePosition.toString());
	}
	
	public void setBasePosition(Position basePosition){
		this.basePosition = basePosition;
	}
	
	public Position getBasePosition(){
		return basePosition;
	}

	public String getBaseId(){
		return baseId;
	}
	
	public abstract String baseType();
	public abstract String getImageFilePath();
	
	
	
}
