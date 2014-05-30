package common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Forgeinstall {
	public static void forge(boolean isServer, String forgeUrl) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		System.out.println("Downloading Forge"); 
		File tmp = File.createTempFile("forge", ".jar");
	        tmp.deleteOnExit();
	        try(InputStream is = new URL(forgeUrl).openStream()) {
	            StreamUtils.saveTo(is, tmp);
	        }
	        System.out.println("Starting Forge installer");
	        String[] args;
	        if(isServer)
	            args = new String[] { "-installServer" };
	        else
	            args = new String[0];

	        //Launch.jar(tmp, args);
	        

	}
}
