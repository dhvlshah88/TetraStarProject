/**
 * 
 */
package Tetra.Base;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TFace;

/**
 * @author Dhaval
 *
 */
public abstract class Base implements ILocatable {

	private Position currentPosition = null;
	
	private String baseId = null;
	
	public Base(){
		
	}
	
	public Base(Position basePosition, String baseId){
		this.currentPosition = basePosition;
		this.baseId = baseId.concat(basePosition.toString());
	}
	
	
	public void setPosition(Position basePosition){
		this.currentPosition = basePosition;
	}
	
	public Position getPosition(){
		return currentPosition;
	}

	public String getBaseId(){
		return baseId;
	}
	
	public abstract String getType();
	public abstract String getImageFilePath();
	
	
	
}
