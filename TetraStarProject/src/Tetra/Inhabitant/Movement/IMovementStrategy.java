/**
 * 
 */
package Tetra.Inhabitant.Movement;

import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public interface IMovementStrategy {

	//
	public Direction getDirection();
	
	//
	public Position getNewPosition(Position currentPosition);
	
}
