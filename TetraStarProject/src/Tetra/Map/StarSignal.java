/**
 * 
 */
package Tetra.Map;

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
	 * This method sets mapPresent variable to true when map is found in vaderbase.
	 */
	public void setMapPresent(){
		this.mapPresent = true;
	}
	
	public boolean isMapIdentical(){
		return mapPresent;
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
