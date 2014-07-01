/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
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


public class start {
	public static void svstart(String mod, String version)
			throws Exception {
		Main.print("test server");

		File dir = new File(FileUtils.getCleanPath());

		Main.print(dir.toString());

		InstallInfo obj = GetInstallInfo.JsonInfo();

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

		FileCreation.FileMake();
		File config = File.createTempFile("Config", ".zip");
		config.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, config);
		}

		FileUtils.unzip(config.toString(), Config.toString());

		ModsDownload.modsDownload(obj, Mods, true);
		
		Main.print("Installing Forge Stuff please Stand by");
		
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
