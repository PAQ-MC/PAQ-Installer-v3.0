package common;

import common.InstallInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class GetInstallInfo {
	public InstallInfo JsonInfo(String url) throws Exception{
		Gson gson = new Gson();
		
		BufferedReader br = read(url);

		// convert the json string back to object
		InstallInfo obj = gson.fromJson(br, InstallInfo.class);
		
		return obj;
		
	}
	
	private static BufferedReader read(String url) throws Exception {

		return new BufferedReader(

		new InputStreamReader(

		new URL(url).openStream()));
	}
}
