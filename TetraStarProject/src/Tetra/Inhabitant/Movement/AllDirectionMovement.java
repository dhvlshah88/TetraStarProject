/**
 * 
 */
package Tetra.Inhabitant.Movement;

import java.util.Random;

import Tetra.Position;
import Tetra.TFace;

/**
 * @author Dhaval
 *
 */
public class AllDirectionMovement implements IMovementStrategy {
	private Random randomGenerator;
	private Direction movementDirection;
	private int rowNo;
	private int columnNo;
	private int randNumber;
	private int TOTAL_ROWS;
	private int TOTAL_COLUMNS;
	private TFace tfaceObj = null;
	Position newPosition = null;

	/**
	 * Default Constructor.
	 */
	public AllDirectionMovement(TFace tfaceObj) {
		randomGenerator = new Random();
		movementDirection = Direction.NORTHEAST;
		this.tfaceObj = tfaceObj;
		TOTAL_ROWS = tfaceObj.getTotalRows();
		TOTAL_COLUMNS = tfaceObj.getTotalColumns();
	}

	public Direction getDirection(){
		return movementDirection;
	}

	public Position getNewPosition(Position currentPosition){
		rowNo = currentPosition.getRowNo();
		columnNo = currentPosition.getColumnNo();

		randNumber = randomNumberGenerator();

		//Below two conditions ignores all the position outside the grid.
		while(rowNo == 0 && (randNumber == 0  || randNumber == 6 || randNumber == 7)  || 
				columnNo == 0 && (randNumber == 4 || randNumber == 5 || randNumber == 6)){
			randNumber = randomNumberGenerator();
		}

		while(rowNo == TOTAL_ROWS && (randNumber == 2  || randNumber == 3 || randNumber == 4)  || 
				columnNo == TOTAL_COLUMNS && (randNumber == 0 || randNumber == 1 || randNumber == 2)){
			randNumber = randomNumberGenerator();
		}

		switch (randNumber) {

		case 0:
			rowNo--;
			movementDirection = Direction.NORTH;
			break;

		case 1:
			rowNo--;
			columnNo++;
			movementDirection = Direction.NORTHEAST;
			break;

		case 2:
			columnNo++;
			movementDirection = Direction.EAST;
			break;

		case 3:
			rowNo++;
			columnNo++;
			movementDirection = Direction.SOUTHEAST;
			break;

		case 4:
			rowNo++; 
			movementDirection = Direction.SOUTH;
			break;

		case 5:
			rowNo++;
			columnNo--;
			movementDirection = Direction.SOUTHWEST;
			break;

		case 6:
			columnNo--;
			movementDirection = Direction.WEST;
			break;

		case 7:
			rowNo--;
			columnNo--;
			movementDirection = Direction.NORTHWEST;
			break;

		default:
			break;
		}

		newPosition = tfaceObj.getPosition(rowNo, columnNo);
		return newPosition;
	}


	public int randomNumberGenerator() {
		return randomGenerator.nextInt(4);
	}


}
