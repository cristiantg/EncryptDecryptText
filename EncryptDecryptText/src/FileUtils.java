import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Read and write into new/existing text files.
 * 
 * @author Cristian TG <cristian.tejedorgarcia[at]ru.nl>
 * @since 1.0
 * @since 1.0
 */
public final class FileUtils {

	/**
	 * Read a text file.
	 * 
	 * @param uri
	 *            Path to the file.
	 * @param encoding
	 *            Encoding of the input file. If null, default value is UTF-8.
	 * @return String with the input file content or null if does not exist.
	 * 
	 */
	public static String readRawFile(final String uri, final String encoding) {
		InputStream inputstream = null;
		final Writer writer = new StringWriter();
		final char[] buffer = new char[1024];
		try {
			inputstream = new FileInputStream(uri);
			final Reader reader = new BufferedReader(new InputStreamReader(
					inputstream, encoding == null ? "UTF-8" : encoding));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
			reader.close();
		} catch (final IOException ex) {
			return null;
		} finally {

			if (inputstream != null) {
				try {
					inputstream.close();
				} catch (final IOException e) {
				}
			}

		}
		return writer.toString();
	}

	/**
	 * Write a new text file.
	 * 
	 * @param uri
	 *            Path of the new file.
	 * @param encoding
	 *            Encoding of the output file. If null, default value is UTF-8.
	 * @param text
	 *            Text to save in the new file.
	 */
	public final static void saveFile(final String uri, final String encoding,
			final String text) {
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(uri), encoding == null ? "UTF-8"
							: encoding));

			out.write(text);
			out.flush();
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Append text to an existing text file.
	 * 
	 * @param uri
	 *            Path of the existing file.
	 * @param encoding
	 *            Encoding of the output file. If null, default value is UTF-8.
	 * @param text
	 *            Text to append in the existing file.
	 */
	public final static void appendFile(final String uri,
			final String encoding, final String text) {
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(uri, true), encoding == null ? "UTF-8"
							: encoding));

			out.append(text).append('\n');
			out.flush();
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Renames a map of filenames with a suffix.
	 * @param filesPath List of files to rename.
	 * @param suffix Suffix to add at the end of the filenames.
	 * @return Map with the filenames changed.
	 */
	public static final HashMap<String,String> renameFiles(
			final ArrayList<String> filesPath, final String suffix) {
		final HashMap<String,String> newFilesPath = new HashMap<String,String> ();
		for (final String fileName : filesPath) {
			final int index = fileName.lastIndexOf(".");
			String newe = fileName.substring(0, index) + suffix
					+ fileName.substring(index);
			
			newFilesPath.put(fileName,newe);
		}
		return newFilesPath;
	}
}
