package Tetra;
/**
 * 
 */

/**
 * @author Dhaval
 *
 */
public class Position {
	
	private int rowNo;
	private int columnNo;
	private String positionId;
	
	/*
	 * Initializes row and column number value.
	 */
	public Position(int rowNo, int columnNo){
		this.rowNo = rowNo;
		this.columnNo = columnNo;
		this.positionId = "P" + Integer.toString(rowNo) + Integer.toString(columnNo);
	}

	//Accessor Methods
	
	
	/*
	 * Gets row number. 
	 */
	public int getRowNo(){
		return rowNo;
	}
	
	/*
	 * Gets column number.
	 */
	public int getColumnNo() {
		return columnNo;
	}
	
	/*
	 * Gets position id.
	 */
	public String getPositionId(){
		return positionId;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * This methods returns true when row and column number of other position object matches with this position 
	 * object's row and column number.
	 */
	public boolean equals(Object objPosition){
		
		if(!(objPosition instanceof Position)){
			return false;
		}
		
		Position otherPosition = (Position) objPosition;
		return rowNo == otherPosition.rowNo && columnNo == otherPosition.columnNo;
		
	}
}
