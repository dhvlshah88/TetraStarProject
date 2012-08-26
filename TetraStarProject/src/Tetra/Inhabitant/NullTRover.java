/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Location;
import Tetra.TFace;

/**
 * @author Pranav
 * This is null object. This object implements NULL OBJECT PATTERN
 */
public class NullTRover extends TRovers {

	/**
	 * 
	 */
	public NullTRover() {
	}

	/*
	 * Below are the do nothing methods.
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

	@Override
	public Location getLocation() {
		return null;
	}

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
	
	@Override
	public String getImageFilePath() {
		return null;
	}

	
}
