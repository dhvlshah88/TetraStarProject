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

	private boolean mapPresent;
	
	/*
	 * Constructor initializes boolean value depending whether the map is present in vaderbase.
	 */
	public StarSignal(boolean mapPresent){
		this.mapPresent = mapPresent;
	}
	
	/*
	 * This method returns green color when map is present at vaderbase else returns red color.
	 */
	public Color getSignalColor(){
		if(mapPresent){
			return Color.GREEN;
		}
		
		return Color.RED;
	}
	
}
