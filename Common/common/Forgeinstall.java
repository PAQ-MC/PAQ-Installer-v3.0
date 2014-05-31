package common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Forgeinstall {
	public static void forgeServer(boolean isServer, String forgeUrl, File forgeDir) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException{
		System.out.println("Downloading Forge"); 
		File tmp = File.createTempFile("forge", ".jar", forgeDir );
	        tmp.deleteOnExit();
	        try(InputStream is = new URL(forgeUrl).openStream()) {
	            StreamUtils.saveTo(is, tmp);
	        }
	        
	        System.out.println("Starting Forge installer");
	        UglyLaunchTempPatch.jar(tmp, isServer);
	}
	
	
public static void forge(boolean isServer, String forgeUrl) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException{
		System.out.println("Downloading Forge"); 
		File tmp = File.createTempFile("forge", ".jar");
	        tmp.deleteOnExit();
	        try(InputStream is = new URL(forgeUrl).openStream()) {
	            StreamUtils.saveTo(is, tmp);
	        }
	        
	        System.out.println("Starting Forge installer");
	        UglyLaunchTempPatch.jar(tmp, isServer);
	}
}
