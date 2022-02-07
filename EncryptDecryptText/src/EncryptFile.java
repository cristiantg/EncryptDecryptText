import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.sun.mail.util.BASE64EncoderStream;

/**
 * Encrypts text files.
 * 
 * @author Cristian TG <cristian.tejedorgarcia[at]ru.nl>
 * @since 1.0
 * @since 1.0
 */
public class EncryptFile {

	/**
	 * Encrypts the text files specified in {@link Base64#DEFAULT}.
	 * 
	 * @param charsetName
	 *            File encoding (e.g., UTF-8).
	 * @param filesPath
	 *            List of filenames to be encrypted and their new filenames.
	 * @param suffix
	 *            String char at the end of the filename of the encryptted file.
	 * @return Encryption/Decryption key.
	 * @return Exception Any problem with the files.
	 */
	public static String encrypt(final String charsetName,
			final HashMap<String, String> newNames, final String suffix)
			throws Exception {

		final SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		final Cipher ecipher = Cipher.getInstance("DES");
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		
		for (Map.Entry<String, String> entry : newNames.entrySet()) {
			FileUtils.saveFile(
					entry.getValue(),
					charsetName,
					new String(BASE64EncoderStream.encode(ecipher
							.doFinal(FileUtils
									.readRawFile(entry.getKey(), charsetName)
									.toString().getBytes(charsetName)))));
		}
		return new String(BASE64EncoderStream.encode(key.getEncoded()),
				charsetName);
	}

}