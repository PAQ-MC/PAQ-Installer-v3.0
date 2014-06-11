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

		System.out.println("\"" + jarFile.getAbsolutePath() + "\"");

		jarFile.deleteOnExit();

		if (Server) {
			Process p = Runtime.getRuntime().exec(
					"java -jar " + "\"" + jarFile.getAbsolutePath() + "\" "
							+ "-installServer");

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
