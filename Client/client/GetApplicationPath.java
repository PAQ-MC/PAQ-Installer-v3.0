package client;

import java.io.File;

public class GetApplicationPath {

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
					+ "/Library/Application Support");
			return AppPath;
		} else if (isLinux) {
			File AppPath = new File(System.getProperty("user.home"));
			return AppPath;
		} else {
			System.out.println("error os not known");
			return null;
		}
	}

}
