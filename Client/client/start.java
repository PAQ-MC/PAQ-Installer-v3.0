package client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import Json.GetInstallInfo;
import Json.InstallInfo;
import Json.JsonEditCode;
import common.FileUtils;
import common.Forgeinstall;
import common.StreamUtils;
import common.ModsDownload;

public class start {

	public static void cstart(String mod, String version, boolean preview)
			throws Exception {
		Gui.consolegui();
		System.out.println("Installing client");
		InstallInfo obj = GetInstallInfo.JsonInfo();

		 Forgeinstall.forge(false, obj.forge().get(0).installer());

		File AppPath = GetApplicationPath.AppPath();
		File PAQ17X = new File(AppPath.toString() + "/PAQ/PAQ1.7.X");
		File Mods17X = new File(PAQ17X.toString() + "/mods");
		File Config17X = new File(PAQ17X.toString() + "/config");

		FileCreation.FileCreation();
		File config = File.createTempFile("Config", ".zip");
		config.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, config);
		}

		FileUtils.unzip(config.toString(), Config17X.toString());

		ModsDownload.modsDownload(obj, Mods17X, true);
		
		JsonEditCode.Main(AppPath.toString() + "/.minecraft", PAQ17X.toString(), obj.forge().get(0).id());
		
		System.out.println("Client install done");
		Thread.sleep(1000);
		System.exit(0);

	}
}