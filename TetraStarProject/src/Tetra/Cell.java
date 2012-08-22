/**
 * 
 */
package Tetra;

/**
 * @author Dhaval
 *
 */
public class Cell {

	private int rowNo;
	private int columnNo;
	private String locationId;
	
	public void setRowNo(int rowNo){
		this.rowNo = rowNo;
	}
	
	public void setColumnNo(int columnNo){
		this.columnNo = columnNo;
	}

	public void setLocationId(int rowNo, int columnNo){
		this.locationId = "L" + Integer.toString(rowNo) + Integer.toString(columnNo);
	}
		
	public int getRowNo(){
		return rowNo;
	}
	
	public int getColumnNo(){
		return columnNo;
	}
		
	public String getLocationId(){
		return locationId;
	}
	
	
	
}
