package common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ModsDownload {
	public static void modsDownload(InstallInfo obj, File Mods17X)
			throws IOException {
		for (int i = 0; i < (obj.mods().size()); i++) {
			System.out.println("Downloading: " + obj.mods().get(i).name());
			URL modUrl = new URL(obj.mods().get(i).link());
			File modfile = new File(Mods17X.toString() + "/"
					+ UrlFormator(modUrl));
			System.out.println(modfile.toString());
			int cont = 0;
			do {
				cont += 1;
				modfile.createNewFile();
				try (InputStream is = modUrl.openStream()) {
					StreamUtils.saveTo(is, modfile);
				}
				if (modfile.length() != obj.mods().get(i).FileSize()) {
					System.out.println("Error File Size does not match for "
							+ obj.mods().get(i).name());
					modfile.delete();
				} else {
					System.out.println("File Size Good Moveing on");
				}

				if (cont == 5) {
					System.out.println("Max retry Reaced Exiting");
					System.exit(1);
				}

			} while ((modfile.length() != obj.mods().get(i).FileSize())
					&& (cont != 5));
		}
	}

	private static String UrlFormator(URL url) {
		String file = url.getFile();
		String filename = file.substring(file.lastIndexOf("/"));
		return filename;

	}
}
