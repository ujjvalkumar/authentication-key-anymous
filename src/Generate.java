import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;


public class Generate {

	String gen() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
		 Cipher encoder = Cipher.getInstance("RSA"); 
		 KeyPair kp = kg.generateKeyPair(); 
		 PublicKey pubKey = kp.getPublic(); 
		 
		 // RSA produces 1024 bits Key
		 
		byte[] pub = pubKey.getEncoded();
		String s = pub.toString();
		
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
