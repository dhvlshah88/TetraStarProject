/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Location;
import Tetra.TFace;
import Tetra.Map.Map;

/**
 * @author pranav
 *
 */
public class NullTRover extends TRovers {

	/**
	 * 
	 */
	public NullTRover() {
	}

	/**
	 * @param name
	 */
	@Override
	public void setName(String name){
	}

	@Override
	public void setTetId(String tetId){
	}

	@Override
	public void setGender(String gender){
	}

	@Override
	public String getName(){
		return null;
	}

	@Override
	public String getTetId(){
		return null;
	}

	@Override
	public String getGender(){
		return null;
	}

	@Override
	public Location getVaderBase() {
		return null;
	}

	/**
	 * @return the loc
	 */
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param loc the loc to set
	 */
	@Override
	public void setLocation(Location currentLocation) {

	}
	
	@Override
	public TFace getTface() {
		return null;
	}

	@Override
	public void setTface(TFace tface) {
		
	}

	
}
