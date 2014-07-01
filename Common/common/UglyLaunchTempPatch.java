/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/


package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class UglyLaunchTempPatch {

	public static void jar(File jarFile, Boolean Server) throws IOException,
			ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException,
			InterruptedException {

		Main.print("\"" + jarFile.getAbsolutePath() + "\"");

		jarFile.deleteOnExit();

		if (Server) {
			Process p = Runtime.getRuntime().exec(
					"java -jar " + "\"" + jarFile.getAbsolutePath() + "\" "
							+ "-installServer");

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));

			String line = null;

			while ((line = input.readLine()) != null) {

				Main.print(line);

			}

			p.waitFor();
			if (p.exitValue() != 0) {
			}
		} else {
			Process p = Runtime.getRuntime().exec(
					"java -jar " + "\"" + jarFile.getAbsolutePath() + "\" ");
			p.waitFor();
			if (p.exitValue() != 0) {
			}
		}

	}
}
