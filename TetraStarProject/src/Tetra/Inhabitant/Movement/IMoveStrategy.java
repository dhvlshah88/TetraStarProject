/**
 * 
 */
package Tetra.Inhabitant.Movement;

import Tetra.Direction;
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
}
