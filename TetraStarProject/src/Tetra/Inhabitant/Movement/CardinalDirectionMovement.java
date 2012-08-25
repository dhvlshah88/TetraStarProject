/**
 * 
 */
package Tetra.Inhabitant.Movement;

import java.util.Random;

import Tetra.Direction;
import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public class CardinalDirectionMovement implements IMoveStrategy {
	
	private Random randomGenerator;
	private Direction movementDirection;
	
	/**
	 * Default Constructor.
	 */
	public CardinalDirectionMovement() {
		randomGenerator = new Random();
		movementDirection = Direction.NORTH;
	}
	
	public Direction getDirection(){
		return movementDirection;
	}
	
	public Position getNewPosition(Position currentPosition){
		Position newPosition = null;
		int rowNo = currentPosition.getRowNo();
		int columnNo = currentPosition.getColumnNo();
		
		int randNumber = randomGenerator.nextInt(4);
		
		switch (randNumber) {
		case 0:
			newPosition = new Position(rowNo--, columnNo);
			movementDirection = Direction.NORTH;
			break;

		case 1:
			newPosition = new Position(rowNo, columnNo++);
			movementDirection = Direction.EAST;
			break;
		
		case 2:
			newPosition = new Position(rowNo++, columnNo);
			movementDirection = Direction.SOUTH;
			break;
			
		case 3:
			newPosition = new Position(rowNo, columnNo--);
			movementDirection = Direction.WEST;
			break;
			
		default:
			break;
		}
		
		return newPosition;
	}

	
	
}
