package server;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import common.FileUtils;
import common.Forgeinstall;
import common.GetInstallInfo;
import common.InstallInfo;


//import common.FileUtils;

public class start {
	public static void svstart(String mod, String version, boolean preview) throws Exception {
		System.out.println("test server");
		
		File dir = new File(FileUtils.getCleanPath());

		System.out.println(dir);
		
		InstallInfo obj = GetInstallInfo.JsonInfo();
		Forgeinstall.forgeServer(true, obj.Forge(), dir);
		
	}
}
