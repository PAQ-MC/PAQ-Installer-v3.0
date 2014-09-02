/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/*
	Created By Isaac Wheeler
*/

package client;



import gui.Downloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;








import common.Main;
import Json.InstallInfo;

public class ModsDownload{

	private static InstallInfo _obj;
	private static File _Mods17X;
	private static int _i;

	//gathers all download data and set up main loop for each file
	public static void modsDownload(InstallInfo obj, File Mods17X,
			Boolean ClientOnly) throws InterruptedException {

		for (int i = 0; i < (obj.mods().size()); i++) {

			_obj = obj;
			_Mods17X = Mods17X;
			_i = i;

			try {
				download(_i, _obj, _Mods17X);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	//main download stuff including getting the url's and file paths runs each time a file needs downloading.
	public static void download(int i, InstallInfo obj, File Mods17X)
			throws Exception {
		Main.print("Downloading: " + obj.mods().get(i).name());

		URL modUrl = null;
		try {
			modUrl = new URL(obj.mods().get(i).link());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
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
					
						 
			Downloader.main(modUrl.toString(), new File(modfile.toString()));
			
			if (modfile.length() != obj.mods().get(i).FileSize()) {

				Main.print("Error File Size does not match for "
						+ obj.mods().get(i).name());

				modfile.delete();

			} else {

				Main.print("File Size Good for "
						+ obj.mods().get(i).name() + " Moving on");

			}

			if (cont == 6) {

				System.out
						.println("Max retry reached Exiting Install Please Try agian later");

				System.exit(1);

			}

		} while ((modfile.length() != obj.mods().get(i).FileSize())
				&& (cont != 6));
	}

}
