/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Position;



/**
 * @author Dhaval
 *
 */
public class TRoverFactory {

	private TRovers tRover = null;
	
	public TRovers createTRover(String type, Position currentPosition){

		tRover = new NullTRover(currentPosition);
		
		if (type.equalsIgnoreCase("TRover")) {
			tRover = new TRovers(currentPosition);
		} else if (type.equalsIgnoreCase("THero")) {
			tRover = new THero(currentPosition);
		} else if (type.equalsIgnoreCase("TVader")) {
			tRover = TVader.getInstance(currentPosition);
		}
		return tRover;
	}
}
