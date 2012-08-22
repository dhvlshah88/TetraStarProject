/**
 * 
 */
package Tetra.Base;


import Tetra.Position;

/**
 * @author Dhaval
 *
 */
public class BaseFactory {
	
	public static Base createBase(String baseType, Position basePosition){
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
