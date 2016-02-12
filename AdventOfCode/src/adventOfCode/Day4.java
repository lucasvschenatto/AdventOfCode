package adventOfCode;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Day4 {

	public int numberToGenerateHashWithPrefix(String key, String prefix) {
		try {
			for(long i = 0; i< Long.MAX_VALUE;i++){
				String fullKey = key.concat(String.valueOf(i));
				byte[] byteHash = MessageDigest.getInstance("MD5").digest(fullKey.getBytes(StandardCharsets.UTF_8));
				String hash = DatatypeConverter.printHexBinary(byteHash);
				if(hash.startsWith(prefix))
					return (int) i;
			}			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	public int numberToGenerateHashStartingWithGivenZeroes(String key, int zeroes) {
		String prefix = "";
		do{
			prefix = prefix.concat("0");
		}while(prefix.length()<zeroes);
		return numberToGenerateHashWithPrefix(key, prefix);
	}
}
