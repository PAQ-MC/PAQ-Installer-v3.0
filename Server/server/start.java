package server;

import java.io.File;

import Json.GetInstallInfo;
import Json.InstallInfo;
import common.FileUtils;
import common.Forgeinstall;


//import common.FileUtils;

public class start {
	public static void svstart(String mod, String version, boolean preview) throws Exception {
		System.out.println("test server");
		
		File dir = new File(FileUtils.getCleanPath());

		System.out.println(dir);
		
		InstallInfo obj = GetInstallInfo.JsonInfo();
		Forgeinstall.forgeServer(true, obj.forge().get(0).installer(), dir);
		
	}
}
