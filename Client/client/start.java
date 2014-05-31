package client;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import common.FileUtils;
import common.Forgeinstall;

public class start {

	public static void cstart(String mod, String version, boolean preview) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InterruptedException {
		System.out.println("test client");
		File dir = new File(FileUtils.getCleanPath());

		System.out.println(dir);
		Forgeinstall.forge(false, common.Main.ForgePath);
	}

}
