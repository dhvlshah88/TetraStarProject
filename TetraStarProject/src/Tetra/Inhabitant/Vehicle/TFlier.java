/**
 * 
 */
package Tetra.Inhabitant.Vehicle;

import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.Movement.TFlierMovement;

/**
 * @author Dhaval
 *
 */
public class TFlier extends Vehicle {
	
	public TFlier(){
		
	}
	
	public TFlier(TFace tfaceObj, String tflierId){
		super(tfaceObj, tflierId);
		this.setMovementStrategy(new TFlierMovement(tfaceObj));
	}
	
	/* (non-Javadoc)
	 * @see Tetra.Inhabitant.Vehicle#moveToPosition()
	 */
	@Override
	public Position moveToPosition(Position currentPosition) {
		return this.getMovementStrategy().getNewPosition(currentPosition);
	}

}
