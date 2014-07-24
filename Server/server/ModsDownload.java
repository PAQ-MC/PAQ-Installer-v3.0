/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package server;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;



import common.Main;
import common.StreamUtils;
import Json.InstallInfo;

public class ModsDownload {
	public static void modsDownload(InstallInfo obj, File Mods17X,
			Boolean ClientOnly) {
		
		for (int i = 0; i < (obj.mods().size()); i++) {

			if ((ClientOnly != obj.mods().get(i).ClientOnly())) {

				Main.print("Downloading: " + obj.mods().get(i).name());

				URL modUrl = null;
				try {
					modUrl = new URL(obj.mods().get(i).link());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

				File modfile = new File(Mods17X.toString() + "/"
						+ obj.mods().get(i).name());

				Main.print(modfile.toString());

				int cont = 0;

				do {

					cont += 1;

					try {
						modfile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try (InputStream is = modUrl.openStream()) {

						StreamUtils.saveTo(is, modfile);

					} catch (IOException e) {
						e.printStackTrace();
					}
					if (modfile.length() != obj.mods().get(i).FileSize()) {

						Main.print("Error File Size does not match for "
								+ obj.mods().get(i).name());

						modfile.delete();

					} else {

						Main.print("File Size Good for "
								+ obj.mods().get(i).name() + " Moveing on");

						if (!ClientOnly) {
						}

					}

					if (cont == 5) {

						System.out
								.println("Max retry reached Exiting Install Please Try agian later");

						System.exit(1);

					}

				} while ((modfile.length() != obj.mods().get(i).FileSize())
						&& (cont != 5));
			}
			
		}
	}

}