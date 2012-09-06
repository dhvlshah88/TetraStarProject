/**
 * 
 */
package Tetra.Inhabitant;

import Tetra.Position;
import Tetra.TFace;

/**
 * @author Dhaval
 * This is null object. This object implements NULL OBJECT PATTERN
 */
public class NullTRover extends TRovers {

	/**
	 * 
	 */
	public NullTRover(Position currentPosition) {
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
	public Position getVaderBasePosition() {
		return null;
	}
	
	@Override
	public void setPosition(Position currentPosition) {
	
	}

	@Override
	public Position getPosition() {
		return null;
	}

	@Override
	public String getImageFilePath() {
		return null;
	}

	
}
