/**
 * 
 */
package Tetra.Base;


import Tetra.Position;

/**
 * @author Dhaval
 * 
 * 
 */
public class BaseFactory {
	
	// Factory method which creates any base given its basetype.
	public static Base createBase(String baseType, Position basePosition){
		
		// This reference variable is been instantiated with NullBase instance that is a null object. 
		// These is done in order to avoid null pointer exception if the base instance is not created properly.
		Base base = new NullBase();
		
		if(baseType.equalsIgnoreCase("THeroBase")){
			base = new THeroBase(basePosition);
		}else if(baseType.equalsIgnoreCase("TVaderBase")){
			base = new TVaderBase(basePosition);
		}else if(baseType.equalsIgnoreCase("MapBase")){
			base = new MapBase(basePosition);
		}else{
			base = new River(basePosition);
		}
	
		return base;
	}

}
