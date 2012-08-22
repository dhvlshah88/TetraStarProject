/**
 * 
 */
package Tetra.Map;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author Dhaval
 *
 */
public class EncryptionStrategyTwo implements IEncrytionStrategy {

	/* (non-Javadoc)
	 * @see Tetra.IEncrytionStrategy#encryptDirection(java.lang.String)
	 */
	@Override
	public String encryptDirection(String direction) {

		String passkey = "nv93h50sk1zh508v";
		String result = null;
		
		SecretKeySpec key = new SecretKeySpec(passkey.getBytes(), "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES", "SunJCE");
	
		cipher.init(Cipher.ENCRYPT_MODE, key);

		result = new String(cipher.doFinal(direction.getBytes()));
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
