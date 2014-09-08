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

import argo.saj.InvalidSyntaxException;
import common.FileUtils;

public class FileCreation {
	
	//code for creating required files
	
	public static void FileMake(File PAQ, File mods, File config) throws IOException, InvalidSyntaxException {

		//checks if correct directory exists and creates it if not
		if (!PAQ.exists()) {
			PAQ.mkdir();
		}

		//checks if directory exists and either creates it if it does not or deletes and recreates it if not
		if (!mods.exists()) {
			mods.mkdir();
		} else {
			FileUtils.DelateDirectory(mods);
			mods.mkdir();
		}

		//checks if directory exists and either creates it if it does not or deletes and recreates it if not
		if (!config.exists()) {
			config.mkdir();
		} else {
			FileUtils.DelateDirectory(config);
			config.mkdir();
		}
	}
}
