import java.util.ArrayList;
import java.util.HashMap;

/**
 * Useful examples of how to use the encryption/decryption utilities.
 * 
 * @author Cristian TG <cristian.tejedorgarcia[at]ru.nl>
 * @since 1.0
 * @since 1.0
 */
public class Tester {

	/**
	 * My favorite encoding.
	 */
	public final static String ENCODING_UTF8 = "UTF-8";

	/**
	 * STEP1: Encrypts a list of files and obtains an encryption key.
	 * STEP2 (optional): Shows (decrypts) the files decrypted.
	 * @param args No params are required.
	 */
	public static void main(final String[] args) {

		final String suffix = "_encrypted";
		final ArrayList<String> filesPath = new ArrayList<String>();
		// Here we add as many files as we want to encrypt
		filesPath.add("./assets/es_es_et_ee_vowel.json");
		filesPath.add("./assets/languages.json");
		// filesPath.add("OTHER_PATH");
		
		String encrypted_key = "";
		final HashMap<String, String> newNames = FileUtils.renameFiles(
				filesPath, suffix);
		// STEP1
		try {
			encrypted_key = EncryptFile.encrypt(ENCODING_UTF8, newNames,
					suffix);
			System.out.println("-- encrypted_key: --\n" + encrypted_key
					+ "\n-- Process finished succesfully. --");

		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		/**
		 // STEP2
		 for (Map.Entry<String, String> entry : newNames.entrySet()) {
			// String key = entry.getKey();
			// String value = entry.getValue();

			final String fileString = FileUtils.readRawFile(entry.getValue(),
					ENCODING_UTF8).trim();
			try {
				final String decryptedText = DecryptString.decrypt(fileString,
						encrypted_key, ENCODING_UTF8);
				System.out.println(decryptedText);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
}