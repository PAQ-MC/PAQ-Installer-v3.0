/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/


package common;

import java.io.File;
import java.io.IOException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class FileUtils {
	public static void folders(String FolderLocation) {
		new File(FolderLocation).mkdir();
	}

	public static String getCleanPath() {
		String workingDir = System.getProperty("user.dir");

		return workingDir;
	}

	public static void DelateDirectory(File directory) {

		// make sure directory exists
		if (!directory.exists()) {

			Main.print("Directory does not exist.");
			System.exit(0);

		} else {

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

	}

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
				}
			}

		} else {
			// if file, then delete it
			file.delete();
		}
	}

	public static void unzip(String Zipfile, String Directry) {
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(Zipfile);
			zipFile.extractAll(Directry);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
