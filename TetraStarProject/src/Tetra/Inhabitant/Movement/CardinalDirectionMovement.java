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
public class CardinalDirectionMovement implements IMovementStrategy {

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
	public CardinalDirectionMovement(TFace tfaceObj) {
		randomGenerator = new Random();
		movementDirection = Direction.NORTH;
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
		while(rowNo == 0 && randNumber == 0 || columnNo == 0 && randNumber == 3){
			randNumber = randomNumberGenerator();
		}

		while(rowNo == TOTAL_ROWS && randNumber == 2 || columnNo == TOTAL_COLUMNS && randNumber == 1){
			randNumber = randomNumberGenerator();
		}

		switch (randNumber) {
		case 0:
			rowNo--;
			movementDirection = Direction.NORTH;
			break;

		case 1:
			columnNo++;
			movementDirection = Direction.EAST;
			break;

		case 2:
			rowNo++;
			movementDirection = Direction.SOUTH;
			break;

		case 3:
			columnNo--;
			movementDirection = Direction.WEST;
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
