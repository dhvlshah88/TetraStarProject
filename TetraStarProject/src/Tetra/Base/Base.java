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
	
	private TFace tfaceObj = null;
	
	public Base(){
		
	}
	
	public Base(Position basePosition, String baseId){
		this.currentPosition = basePosition;
		this.baseId = baseId.concat(basePosition.toString());
	}
	
	public void setTface(TFace tfaceObj){
		this.tfaceObj = tfaceObj;
	}
	
	public TFace getTface(){
		return tfaceObj;
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
