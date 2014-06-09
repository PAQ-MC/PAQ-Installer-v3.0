package client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import common.FileUtils;
import common.Forgeinstall;
import common.GetInstallInfo;
import common.InstallInfo;
import common.StreamUtils;
import common.ModsDownload;

public class start {

	public static void cstart(String mod, String version, boolean preview)
			throws Exception {
		System.out.println("test client");

		InstallInfo obj = GetInstallInfo.JsonInfo();

		// Forgeinstall.forge(false, obj.Forge());

		File AppPath = GetApplicationPath.AppPath();
		File PAQ164 = new File(AppPath.toString() + "/PAQ/Instances/PAQ");
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

		ModsDownload.modsDownload(obj, Mods17X);

	}
}

// Users/IsaacWheeler/Library/Application Support/PAQ/Instances/PAQ