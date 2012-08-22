/**
 * 
 */
package Tetra.Inhabitant;


/**
 * @author Dhaval
 *
 */
public class TVader extends TRovers {

	/*
	 * Default Constructor 
	 */
	public TVader(){
	
	}
	
	public TVader(String name, String tetId, String gender){
		super(name, tetId, gender);
	}
	
	public String getType(){
		return "TVader";
	}
}
