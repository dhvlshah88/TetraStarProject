/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Position;


/**
 * @author Dhaval
 *
 */
public class TVader extends TRovers {

	/*
	 * Default Constructor 
	 */
	public TVader(){
	
	}
	
	public TVader(Position currentPosition){
		super(currentPosition);
	}
	
	public String getType(){
		return "TVader";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getImageFilePath(){
		return "src/images/Megatron.jpg";
	}
}
