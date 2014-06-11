package Json;

import common.Versioninfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class GetInstallInfo {
	public static InstallInfo JsonInfo() throws Exception {
		Gson gson = new Gson();

		BufferedReader br = read("http://magetech.no-ip.org/versioninfo.json");

		Versioninfo Versioninfo = gson.fromJson(br, Versioninfo.class);

		BufferedReader br2 = read(Versioninfo.InstallInfoDirectory()
				+ Versioninfo.versions().get(Versioninfo.versions().size() - 1)
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
