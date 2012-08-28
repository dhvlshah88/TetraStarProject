/**
 * 
 */
package Tetra;

import java.util.HashMap;

/**
 * @author Dhaval
 *
 */
public class TFace {

	/**
	 * 
	 */
	
	private HashMap<String, Position> positionCollection = null;
	private Position position = null;
	private int totalRows, totalColumns = 0;
	
	/**
	 * Parameterized Constructor
	 * @param totalRows <i>Total number of rows</i>
	 * @param totalColumns <i>Total number of columns</i>
	 */
	public TFace(int totalRows, int totalColumns) {
		this.totalRows = totalRows;
		this.totalColumns = totalColumns;
		buildHashMap(totalRows, totalColumns);
	}
	
	/**
	 * This methods builds hash map of <code>Position</code> instance by creating them. A total of rows * columns 
	 * <code>Position</code> instance are created and stored in hash map.
	 * @param totalRows <i>Total number of rows</i>
	 * @param totalColumns <i>Total number of columns</i>
	 */
	public void buildHashMap(int totalRows, int totalColumns){
		positionCollection = new HashMap<String, Position>();
		if(!positionCollection.isEmpty()){
			return;
		}
		
		for(int rowNo = 0; rowNo < totalRows; rowNo++ ){
			for(int columnNo = 0; columnNo < totalColumns; columnNo++){
				position = createPosition(rowNo, columnNo);
				positionCollection.put(position.toString(), position);
			}
		}
	}
	
	/**
	 * This method is factory method for creating <code>Position</code> objects.
	 * @param rowNo <i>row number</i>
	 * @param columnNo <i>column number</i>
	 * @return {@link Position} object.
	 */
	public Position createPosition(int rowNo, int columnNo){
		return new Position(rowNo, columnNo);
	}
	
	/**
	 * This method returns the hash map build by <code>buildHashMap(int, int)</code>.
	 * @return {@link HashMap} of <code>Position</code> objects.
	 */
	public HashMap<String, Position> getPositionCollection(){
		return positionCollection;
	}
	
	/**
	 * This method gets total number of rows in grid.
	 * @return {@link Integer} <code>totalRows</code>
	 */
	public int getTotalRows(){
		return totalRows;
	}
	
	/**
	 * This method gets total number of columns to grid.
	 * @return {@link Integer} <code>totalColumns</code>
	 */
	public int getTotalColumns(){
		return totalColumns;
	}
	
	public Position getPosition(int rowNo, int columnNo){
		return positionCollection.get(Integer.toString(rowNo).concat(Integer.toString(columnNo)));
	}
}
