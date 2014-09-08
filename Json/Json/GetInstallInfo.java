/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

/***
 Created By Isaac Wheeler
 */

package Json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import common.Main;

public class GetInstallInfo {
	public static InstallInfo JsonInfo() throws Exception {
		String version = Main.version;
		Gson gson = new Gson();
		BufferedReader br;

		System.out.println(Main.mod);
		
		br = read(Main.mod);

		Versioninfo Versioninfo = gson.fromJson(br, Versioninfo.class);

		if (version != null) {

		} else {
			version = Versioninfo.versions()
					.get(Versioninfo.versions().size() - 1).toString();
		}
		BufferedReader br2 = read(Versioninfo.InstallInfoDirectory() + version
				+ ".json");

		InstallInfo obj = gson.fromJson(br2, InstallInfo.class);

		return obj;

	}

	private static BufferedReader read(String url) throws Exception {

		return new BufferedReader(

		new InputStreamReader(

		new URL(url).openStream()));
	}
}
