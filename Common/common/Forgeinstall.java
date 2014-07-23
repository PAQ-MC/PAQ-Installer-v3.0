/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

/***
 Created By Isaac Wheeler
 */

package common;

import gui.Downloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Forgeinstall {
	
	//code for installing server Side via forge installer jar not currently used left for postarity
	public static void forgeServer(boolean isServer, String forgeUrl,
			File forgeDir) throws IOException, ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException,
			IllegalAccessException, InterruptedException {
		Main.print("Downloading Forge");
		File tmp = File.createTempFile("forge", ".jar", forgeDir);
		tmp.deleteOnExit();
		try (InputStream is = new URL(forgeUrl).openStream()) {
			StreamUtils.saveTo(is, tmp);
		}

		Main.print("Starting Forge installer");
		UglyLaunchTempPatch.jar(tmp, isServer);
	}

	// code for installing client side forge
	public static void forge(boolean isServer, String forgeUrl)
			throws Exception {
		Main.print("Downloading Forge");

		File tmp = File.createTempFile("forge", ".jar");
		tmp.deleteOnExit();

		try {
			Downloader.main(forgeUrl, tmp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Main.print("Starting Forge installer");
		UglyLaunchTempPatch.jar(tmp, isServer);
	}
}
