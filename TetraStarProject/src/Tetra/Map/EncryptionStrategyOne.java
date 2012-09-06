/**
 * 
 */
package Tetra.Map;


/**
 * @author Dhaval
 *
 */
public class EncryptionStrategyOne implements IEncryptionStrategy {

	/* (non-Javadoc)
	 * @see Tetra.IEncrytionStrategy#encryptDirection(java.lang.String)
	 * 
	 * This method encrypts the direction from star map by reversing the string in direction. This is one of the strategy
	 * used by the THero.
	 */
	
	@Override
	public String encryptDirection(String direction) {
		
		char[] dirArray = direction.toCharArray();
		
		String reverseDirString = "";
		for (int i = dirArray.length-1; i>=0; i--){
			reverseDirString = reverseDirString + dirArray[i];
		}
		
		return reverseDirString;
	}

}
