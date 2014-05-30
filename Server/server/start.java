package server;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import common.Forgeinstall;


//import common.FileUtils;

public class start {
	public static void svstart(String mod, String version, boolean preview) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
		System.out.println("test server");
		
		Forgeinstall.forge(true, common.Main.ForgePath);
		
	}
}
