/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/


package common;

import org.xeustechnologies.jcl.JarClassLoader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * Created by Aleksander on 13.12.13.
 */
public class Launch {
	public static void jar(File jarFile, String[] args) throws IOException,
			ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		String mainClassName = null;

		try (InputStream is = new FileInputStream(jarFile);
				JarInputStream jarStream = new JarInputStream(is)) {
			Manifest mf = jarStream.getManifest();
			Attributes attributes = mf.getMainAttributes();
			mainClassName = attributes.getValue("Main-Class");
		}

		if (mainClassName == null)
			throw new IllegalStateException("No main class found in manifest");

		JarClassLoader jcl = new JarClassLoader();
		jcl.add(jarFile.getAbsolutePath());
		try (Closeable context = ContextUtils.enter(jcl)) {
			Class<?> mainClass = Class.forName(mainClassName, true, jcl);
			Method method = mainClass.getDeclaredMethod("main", String[].class);
			method.invoke(null, new Object[] { args });
		}
	}
}
