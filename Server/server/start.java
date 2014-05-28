package server;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;

import common.FileUtils;
import common.Forgeinstall;


//import common.FileUtils;

public class start {
	public static void svstart(String mod, String version, boolean preview) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
		System.out.println("test server");
		
		Forgeinstall.forge(true, "http://fileserver.mage-tech.org/PAQ/1.7.2/forge-1.7.2-10.12.1.1099-installer.jar");
		
	}
}
