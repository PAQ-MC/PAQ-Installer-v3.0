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

public class start {

	public static void cstart(String mod, String version, boolean preview)
			throws Exception {
		System.out.println("test client");
		File dir = new File(FileUtils.getCleanPath());

		System.out.println(dir);
		// Forgeinstall.forge(false, common.Main.ForgePath);
		File AppPath = GetApplicationPath.AppPath();

		File PAQ164 = new File(AppPath.toString() + "/PAQ/Instances/PAQ");

		if (PAQ164.exists()) {
			PAQ164.renameTo(new File(AppPath.toString() + "/PAQ/OldPAQ1.6.4"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Installer"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Launcher"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Instances"));
		}

		File PAQ17X = new File(AppPath.toString() + "/PAQ/PAQ1.7.X");
		if (!PAQ17X.exists()) {
			PAQ17X.mkdir();
		}

		File Mods17X = new File(PAQ17X.toString() + "/mods");
		if (!Mods17X.exists()) {
			Mods17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Mods17X);
			Mods17X.mkdir();
		}

		File Config17X = new File(PAQ17X.toString() + "/config");
		if (!Config17X.exists()) {
			Config17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Config17X);
			Config17X.mkdir();
		}

		InstallInfo obj = GetInstallInfo
				.JsonInfo("http://magetech.no-ip.org/test.json");

		File tmp = File.createTempFile("Config", ".jar");
		tmp.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, tmp);
		}

		FileUtils.unzip(tmp.toString(), Config17X.toString());

	}

}

// Users/IsaacWheeler/Library/Application Support/PAQ/Instances/PAQ