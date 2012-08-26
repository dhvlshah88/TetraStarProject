/**
 * 
 */
package Tetra;

/**
 * @author Dhaval
 *
 */
public interface ITetraCollection {

	//
	public boolean comparePosition(Position nextPosition);
	
	//
	public boolean addPosition(Position currentPosition);
	
	//
	public boolean changePosition(Position currentPosition, Position nextPosition);

}
