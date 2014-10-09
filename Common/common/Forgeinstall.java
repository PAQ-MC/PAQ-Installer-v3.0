/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

package common;

import gui.Downloader;
import gui.downloaderBackup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
/**
 * Class File for the installation of forge 
 * @author IsaacWheeler
 *
 */
public class Forgeinstall {
	
	/**
	 * code for installing server Side via forge installer jar not currently used left for postarity
	 * @param isServer boolean to check if server
	 * @param forgeUrl location of forge file for downloading
	 * @param forgeDir location of forge file that was downloaded
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InterruptedException
	 */
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

	/**
	 * code for installing client side forge
	 * @param isServer boolean for if it is server or not 
	 * @param forgeUrl url of forge for download 
	 * @throws Exception
	 */
	public static void forge(boolean isServer, String forgeUrl)
			throws Exception {
		Main.print("Downloading Forge");

		File tmp = File.createTempFile("forge", ".jar");
		tmp.deleteOnExit();

			downloaderBackup download = new downloaderBackup(forgeUrl, tmp);
			download.downloader();

		Main.print("Starting Forge installer");
		UglyLaunchTempPatch.jar(tmp, isServer);
	}
}
