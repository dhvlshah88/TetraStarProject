/**
 * 
 */
package Tetra;

import java.awt.Color;

/**
 * @author Dhaval
 *
 */
public class StarSignal {

	private boolean mapPresent = false;
	
	/**
	 * Default Constructor 
	 */
	public StarSignal(){
	}
	
	/**
	 * This method sets mapPresent variable true when map is found in vaderbase.
	 */
	public void mapPresent(){
		this.mapPresent = true;;
	}
	
	/**
	 * This method returns green color when map is present at vaderbase else returns red color.
	 */
	public Color getSignalColor(){
		if(mapPresent){
			return Color.GREEN;
		}
		
		return Color.RED;
	}
	
}
