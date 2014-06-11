package Json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class GetInstallInfo {
	public static InstallInfo JsonInfo(String version,
			String versionInfoRepostory) throws Exception {
		Gson gson = new Gson();

		if (versionInfoRepostory != null) {

		} else {
			//versionInfoRepostory = new URL("http://mage-tech.org/PAQ/versioninfo.json").toString();
		}
		BufferedReader br = read("http://mage-tech.org/PAQ/versioninfo.json");

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
