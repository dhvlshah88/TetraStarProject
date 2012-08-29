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
public class TFlierMovement implements IMovementStrategy {

	private Random randomGenerator;
	private Direction movementDirection;
	private int rowNo;
	private int columnNo;
	private int prevRowNo;
	private int prevColumnNo;
	private int TOTAL_ROWS;
	private int TOTAL_COLUMNS;
	private TFace tfaceObj = null;
	Position newPosition = null;

	/**
	 * Parameterized Constructor.
	 * @param tfaceObj - TFace object.
	 */
	public TFlierMovement(TFace tfaceObj) {
		randomGenerator = new Random();
		movementDirection = Direction.NORTH;
		this.tfaceObj = tfaceObj;
		TOTAL_ROWS = tfaceObj.getTotalRows();
		TOTAL_COLUMNS = tfaceObj.getTotalColumns();
	}

	/* (non-Javadoc)
	 * @see Tetra.Inhabitant.Movement.IMoveStrategy#getDirection()
	 */
	@Override
	public Direction getDirection() {
		return movementDirection;
	}

	/**
	 * This method gets random new position from position collection hash map.
	 * @param currentPosition - existing position.
	 * @return {@link Position} - random new position.
	 */
	@Override
	public Position getNewPosition(Position currentPosition) {

		prevRowNo = currentPosition.getRowNo();
		prevColumnNo = currentPosition.getColumnNo();

		rowNo = randomRowNoGenerator();
		columnNo = randomColumnNoGenerator();

		if(prevRowNo == rowNo){
			if(prevColumnNo > columnNo){
				movementDirection = Direction.WEST;
			}else if(prevColumnNo < columnNo){
				movementDirection = Direction.EAST;
			}
		}

		if(prevColumnNo == columnNo){
			if(prevRowNo > rowNo){
				movementDirection = Direction.NORTH;
			}else if(prevRowNo < rowNo){
				movementDirection = Direction.SOUTH;
			}
		}

		if(prevRowNo > rowNo){
			if(prevColumnNo > columnNo){
				movementDirection = Direction.NORTHWEST;
			}else{
				movementDirection = Direction.NORTHEAST;
			}
		}else if(prevRowNo < rowNo){
			if(prevColumnNo > columnNo){
				movementDirection = Direction.SOUTHWEST;
			}else{
				movementDirection = Direction.SOUTHEAST;
			}
		}

		newPosition = tfaceObj.getPosition(rowNo, columnNo);
		return newPosition;
	}

	/**
	 * This method generates a random number between 0 and total no. of rows.
	 * @return {@link Integer}
	 */
	public int randomRowNoGenerator() {
		return randomGenerator.nextInt(TOTAL_ROWS);
	}

	/**
	 * This method generates a random number between 0 and total no. of columns.
	 * @return {@link Integer}
	 */
	public int randomColumnNoGenerator(){
		return randomGenerator.nextInt(TOTAL_COLUMNS);
	}
}
