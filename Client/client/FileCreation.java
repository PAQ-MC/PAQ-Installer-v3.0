/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/


package client;

import java.io.File;
import java.io.IOException;

import Json.JsonEditCodeOldPAQ;
import argo.saj.InvalidSyntaxException;
import common.FileUtils;

public class FileCreation {
	
	//code for creating required files
	
	public static void FileMake() throws IOException, InvalidSyntaxException {
		File AppPath = GetApplicationPath.AppPath();
		File PAQ164 = new File(AppPath.toString() + "/PAQ/Instances/PAQ");
		File PAQ17X = new File(AppPath.toString() + "/PAQ/PAQ1.7.X");
		File Mods17X = new File(PAQ17X.toString() + "/mods");
		File Config17X = new File(PAQ17X.toString() + "/config");

		
		//code for handling old PAQ installer (no longer relevant left in for reference till 1.8.X update)
		if (PAQ164.exists()) {
			PAQ164.renameTo(new File(AppPath.toString() + "/PAQ/OldPAQ1.6.4"));
			JsonEditCodeOldPAQ.Main(AppPath.toString()
					+ "/.minecraft", "1.10.0",
					AppPath.toString() + "/PAQ/OldPAQ1.6.4");
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Installer"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Launcher"));
			FileUtils.DelateDirectory(new File(AppPath.toString()
					+ "/PAQ/Instances"));
		}

		//checks if correct directory exists and creates it if not
		if (!PAQ17X.exists()) {
			PAQ17X.mkdir();
		}

		//checks if directory exists and either creates it if it does not or deletes and recreates it if not
		if (!Mods17X.exists()) {
			Mods17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Mods17X);
			Mods17X.mkdir();
		}

		//checks if directory exists and either creates it if it does not or deletes and recreates it if not
		if (!Config17X.exists()) {
			Config17X.mkdir();
		} else {
			FileUtils.DelateDirectory(Config17X);
			Config17X.mkdir();
		}
	}
}
