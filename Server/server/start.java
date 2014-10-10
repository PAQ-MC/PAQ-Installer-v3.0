/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/
package server;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import client.FileCreation;
import Json.GetInstallInfo;
import Json.InstallInfo;
import common.FileUtils;
import common.Main;
import common.StreamUtils;

/**
 * Class file for server side install code
 * @author IsaacWheeler
 *
 */
public class start {
	/**
	 * main function for server side install
	 * @throws Exception 
	 */
	public static void svstart()
			throws Exception {
		Main.print("server");
		
		//getting current directory of where the file is being run

		File dir = new File(FileUtils.getCleanPath());
		
		//printing directory for refrence

		Main.print(dir.toString());
		
		//getting install config file

		InstallInfo obj = GetInstallInfo.JsonInfo();
		
		//creating mods and config folders in current directory

		File Mods = new File(dir.toString() + "/mods");
		File Config = new File(dir.toString() + "/config");

		if (Mods.exists()) {
			FileUtils.DelateDirectory(Mods);
		}
		Mods.mkdir();

		if (Config.exists()) {
			FileUtils.DelateDirectory(Config);
		}
		Config.mkdirs();
		
		//downloading tmp config zip

		
		File config = File.createTempFile("Config", ".zip");
		config.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, config);
		}

		//unziping config file to config folder
		
		FileUtils.unzip(config.toString(), Config.toString());
		
		//downloading mods to mods folder

		ModsDownload.modsDownload(obj, Mods, true);
		
		Main.print("Installing Forge Stuff please Stand by");
		
		//checking for existing forge stuff and removing if it exists
		
		File libraies = new File(dir.toString() + "/libraries");
		
		if (libraies.exists()) {
			FileUtils.DelateDirectory(libraies);
		}
		
		File mcserver = new File(dir.toString() + "/minecraft_server.1.7.2.jar");  //TODO: make better handling for future minecraft versions
		
		if (mcserver.exists()) {
			mcserver.delete();
		}
		
		File paqServer = new File(dir.toString() + "/PAQ.jar");
		
		if (paqServer.exists()){
			paqServer.delete();
		}
		
		//downloading forge server zip and extracting to current directory
		
		File ServerZip = File.createTempFile("ServerZip", ".zip");
		ServerZip.deleteOnExit();
		try (InputStream is = new URL(obj.forge().get(0).ServerZip())
				.openStream()) {
			StreamUtils.saveTo(is, ServerZip);
		}

		FileUtils.unzip(ServerZip.toString(),
				dir.toString());

		
		Main.print("Server Install Done");
	}
}
