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
public class AllDirectionMovement implements IMoveStrategy {
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
	public AllDirectionMovement(int maximumRows, int maximumColumns) {
		randomGenerator = new Random();
		movementDirection = Direction.NORTHEAST;
		MAX_ROWS = maximumRows;
		MAX_COLUMNS = maximumColumns;
	}
	
	public Direction getDirection(){
		return movementDirection;
	}
	
	public Position getNewPosition(Position currentPosition){
		Position newPosition = null;
		int rowNo = currentPosition.getRowNo();
		int columnNo = currentPosition.getColumnNo();
		
		randNumber = randomNumberGenerator();
		
		//Below two conditions ignores all the position outside the grid.
		while(rowNo == 0 && (randNumber == 0  || randNumber == 6 || randNumber == 7)  || 
				columnNo == 0 && (randNumber == 4 || randNumber == 5 || randNumber == 6)){
			randNumber = randomNumberGenerator();
		}

		while(rowNo == MAX_ROWS && (randNumber == 2  || randNumber == 3 || randNumber == 4)  || 
				columnNo == MAX_COLUMNS && (randNumber == 0 || randNumber == 1 || randNumber == 2)){
			randNumber = randomNumberGenerator();
		}

		switch (randNumber) {
		
		case 0:
			newPosition = new Position(rowNo--, columnNo);
			movementDirection = Direction.NORTH;
			break;

		case 1:
			newPosition = new Position(rowNo--, columnNo++);
			movementDirection = Direction.NORTHEAST;
			break;
			
		case 2:
			newPosition = new Position(rowNo, columnNo++);
			movementDirection = Direction.EAST;
			break;

		case 3:
			newPosition = new Position(rowNo++, columnNo++);
			movementDirection = Direction.SOUTHEAST;
			break;
		
		case 4:
			newPosition = new Position(rowNo++, columnNo);
			movementDirection = Direction.SOUTH;
			break;
			
		case 5:
			newPosition = new Position(rowNo++, columnNo--);
			movementDirection = Direction.SOUTHWEST;
			break;
			
		case 6:
			newPosition = new Position(rowNo, columnNo--);
			movementDirection = Direction.WEST;
			break;
	
		case 7:
			newPosition = new Position(rowNo--, columnNo--);
			movementDirection = Direction.NORTHWEST;
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
