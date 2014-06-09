package client;

import java.io.File;

import common.FileUtils;

public class FileCreation {
	public static void FileCreation() {
		File AppPath = GetApplicationPath.AppPath();
		File PAQ164 = new File(AppPath.toString() + "/PAQ/Instances/PAQ");
		File PAQ17X = new File(AppPath.toString() + "/PAQ/PAQ1.7.X");
		File Mods17X = new File(PAQ17X.toString() + "/mods");
		File Config17X = new File(PAQ17X.toString() + "/config");

		if (PAQ164.exists()) {
			PAQ164.renameTo(new File(AppPath.toString() + "/PAQ/OldPAQ1.6.4"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Installer"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Launcher"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Instances"));
		}

		if (!PAQ17X.exists()) {
			PAQ17X.mkdir();
		}

		if (!Mods17X.exists()) {
			Mods17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Mods17X);
			Mods17X.mkdir();
		}

		if (!Config17X.exists()) {
			Config17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Config17X);
			Config17X.mkdir();
		}
	}
}
