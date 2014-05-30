package common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UglyLaunchTempPatch {

	public static void jar(File jarFile, String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
		
		Process p = Runtime.getRuntime().exec(("java -jar" + jarFile.getPath()) + Arg);
		
		p.waitFor();
		if (p.exitValue() != 0) {
		}
	
	}
}
