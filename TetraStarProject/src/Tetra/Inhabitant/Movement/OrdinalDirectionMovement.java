/**
 * 
 */
package Tetra.Inhabitant.Movement;

import java.util.Random;

import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public class OrdinalDirectionMovement implements IMoveStrategy {

	private Random randomGenerator;
	private Direction movementDirection;
	
	/**
	 * Default Constructor.
	 */
	public OrdinalDirectionMovement() {
		randomGenerator = new Random();
		movementDirection = Direction.NORTHEAST;
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
			newPosition = new Position(rowNo--, columnNo++);
			movementDirection = Direction.NORTHEAST;
			break;

		case 1:
			newPosition = new Position(rowNo++, columnNo++);
			movementDirection = Direction.SOUTHEAST;
			break;
		
		case 2:
			newPosition = new Position(rowNo++, columnNo--);
			movementDirection = Direction.SOUTHWEST;
			break;
			
		case 3:
			newPosition = new Position(rowNo--, columnNo--);
			movementDirection = Direction.NORTHWEST;
			break;
			
		default:
			break;
		}
		
		return newPosition;
	}

	
	
	
}
