/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

/***
 Created By Isaac Wheeler
 */

package client;

import java.io.File;

import common.Main;

public class GetApplicationPath {

	// code for getting os dependent file paths
	public static File AppPath() {
		String os = System.getProperty("os.name").toLowerCase();
		boolean isWindows, isMac, isLinux;

		isWindows = (os.indexOf("win") >= 0);
		isMac = (os.indexOf("mac") >= 0);
		isLinux = (os.indexOf("nux") >= 0);

		if (isWindows) {
			File AppPath = new File(System.getenv("APPDATA"));
			return AppPath;

		} else if (isMac) {
			File AppPath = new File(System.getProperty("user.home")
					+ "/Library/Application Support"); // does not currently
														// work on mac more
														// testing needed
			return AppPath;
		} else if (isLinux) {
			File AppPath = new File(System.getProperty("user.home")); // is not
																		// well
																		// tested
																		// on
																		// yet
			return AppPath;
		} else {
			Main.print("error os not known");
			return null;
		}
	}

	public static String minecraftpath() {
		String os = System.getProperty("os.name").toLowerCase();
		boolean isWindows, isMac, isLinux;

		isWindows = (os.indexOf("win") >= 0);
		isMac = (os.indexOf("mac") >= 0);
		isLinux = (os.indexOf("nux") >= 0);

		if (isWindows) {
			String AppPath = System.getenv("APPDATA") + "/.minecraft/";
			return AppPath;
		} else if (isMac) {
			String AppPath = System.getProperty("user.home")
					+ "/Library/Application Support/minecraft"; // does not currently work on mac more testing needed
			return AppPath;
		} else if (isLinux) {
			String AppPath = System.getProperty("user.home") + "/.minecraft"; // is not well tested on yet
			return AppPath;
		} else {
			Main.print("error os not known");
			return null;
		}
	}

}
