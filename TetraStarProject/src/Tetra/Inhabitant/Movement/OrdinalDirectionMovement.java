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
public class OrdinalDirectionMovement implements IMovementStrategy {

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
	public OrdinalDirectionMovement(TFace tfaceObj) {
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
		while(rowNo == 0 && (randNumber == 0  || randNumber == 3)  || 
				columnNo == 0 && (randNumber == 2 || randNumber == 3)){
			randNumber = randomNumberGenerator();
		}

		while(rowNo == TOTAL_ROWS && (randNumber == 1  || randNumber == 2)  || 
				columnNo == TOTAL_COLUMNS && (randNumber == 0 || randNumber == 1)){
			randNumber = randomNumberGenerator();
		}


		switch (randNumber) {
		case 0:
			rowNo--;
			columnNo++;
			movementDirection = Direction.NORTHEAST;
			break;

		case 1:
			rowNo++;
			columnNo++;
			movementDirection = Direction.SOUTHEAST;
			break;

		case 2:
			rowNo++;
			columnNo--;
			movementDirection = Direction.SOUTHWEST;
			break;

		case 3:
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
