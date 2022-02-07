import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.mail.util.BASE64DecoderStream;

/**
 * Decrypts text Strings.
 * 
 * @author Cristian TG <cristian.tejedorgarcia[at]ru.nl>
 * @since 1.0
 * @since 1.0
 */
public final class DecryptString {

	/**
	 * Decrypts a text String in {@link Base64#DEFAULT}.
	 * 
	 * @param str
	 *            String to decrypt.
	 * @param Key
	 *            Encrypted key generated with {@link
	 *            EncryptFile#encrypt(String, java.util.ArrayList, Stri}.
	 * @param charsetName
	 *            Text String encoding (e.g., UTF-8).
	 * @return Decrypted text.
	 * @throws Exception
	 *             Any problem during the process.
	 */
	public static String decrypt(final String str, final String Key,
			final String charsetName) throws Exception {
		Cipher dcipher = Cipher.getInstance("DES");
		dcipher.init(
				Cipher.DECRYPT_MODE,
				new SecretKeySpec(BASE64DecoderStream.decode(Key
						.getBytes(charsetName)), "DES"));
		byte[] dec = BASE64DecoderStream.decode(str.getBytes());
		byte[] utf8 = dcipher.doFinal(dec);
		return new String(utf8, charsetName);
	}

}