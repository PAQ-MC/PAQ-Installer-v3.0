package server;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import client.FileCreation;
import Json.GetInstallInfo;
import Json.InstallInfo;
import common.FileUtils;
import common.Forgeinstall;
import common.ModsDownload;
import common.StreamUtils;

//import common.FileUtils;

public class start {
	public static void svstart(String mod, String version, boolean preview)
			throws Exception {
		System.out.println("test server");

		File dir = new File(FileUtils.getCleanPath());

		System.out.println(dir);

		InstallInfo obj = GetInstallInfo.JsonInfo();

		File Mods17X = new File(dir.toString() + "/mods");
		File Config17X = new File(dir.toString() + "/config");

		if (Mods17X.exists()) {
			Mods17X.delete();
		}
		Mods17X.mkdir();

		if (Config17X.exists()) {
			Config17X.delete();
		}
		Config17X.mkdirs();

		FileCreation.FileCreation();
		File config = File.createTempFile("Config", ".zip");
		config.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, config);
		}

		FileUtils.unzip(config.toString(), Config17X.toString());

		ModsDownload.modsDownload(obj, Mods17X, true);
		
		System.out.println("Installing Forge Stuff please Stand by");

		Forgeinstall.forgeServer(true, obj.forge().get(0).installer(), dir);
		
		System.out.println("Server Install Done");
	}
}
