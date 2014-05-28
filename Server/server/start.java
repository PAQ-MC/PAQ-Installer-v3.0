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
		
		Forgeinstall.forge(true, "http://mage-tech.org/PAQ/forge-1.6.4-9.11.1.965-installer.jar");
		
	}
}
