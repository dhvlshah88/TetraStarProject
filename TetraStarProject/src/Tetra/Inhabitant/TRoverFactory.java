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

	private TVader tVader=null;

	public TRovers createTRover(String type, Position currentPosition){

		TRovers tRover=null;
		if (type.equals("TRover")) {
			tRover = new TRovers(currentPosition);
		} else if (type.equals("THero")) {
			tRover = new THero(currentPosition);
		} else if (type.equals("TVader")) {
			tRover = createTVaderIfNotPresent(currentPosition);
		}
		return tRover;
	}

	private TVader createTVaderIfNotPresent(Position currentPosition){
		if(tVader==null){
			tVader=new TVader(currentPosition);
		}

		return tVader;
	}
}
