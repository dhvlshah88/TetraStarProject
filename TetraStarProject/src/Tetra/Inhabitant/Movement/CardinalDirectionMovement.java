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
public class CardinalDirectionMovement implements IMoveStrategy {
	
	private Random randomGenerator;
	private Direction movementDirection;
	private int rowNo;
	private int columnNo;
	private int randNumber;
	private int MAX_ROWS;
	private int MAX_COLUMNS;
	
	
	/**
	 * Default Constructor.
	 */
	public CardinalDirectionMovement(int maximumRows, int maximumColumns) {
		randomGenerator = new Random();
		movementDirection = Direction.NORTH;
		MAX_ROWS = maximumRows;
		MAX_COLUMNS = maximumColumns;
	}
	
	public Direction getDirection(){
		return movementDirection;
	}
	
	public Position getNewPosition(Position currentPosition){
		Position newPosition = null;
		rowNo = currentPosition.getRowNo();
		columnNo = currentPosition.getColumnNo();
		
		randNumber = randomNumberGenerator();
		
		//Below two conditions ignores all the position outside the grid.
		while(rowNo == 0 && randNumber == 0 || columnNo == 0 && randNumber == 3){
			randNumber = randomNumberGenerator();
		}
		
		while(rowNo == MAX_ROWS && randNumber == 2 || columnNo == MAX_COLUMNS && randNumber == 1){
			randNumber = randomNumberGenerator();
		}
		
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

	@Override
	public int randomNumberGenerator() {
		return randomGenerator.nextInt(4);
	}
	
	
}
