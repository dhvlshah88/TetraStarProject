/**
 * 
 */
package Tetra.Inhabitant.Movement;

import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public interface IMoveStrategy {

	//
	public Direction getDirection();
	
	//
	public Position getNewPosition(Position currentPosition);
	
	//
	public int randomNumberGenerator();
}
