/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */
package client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import argo.saj.InvalidSyntaxException;
import Json.GetInstallInfo;
import Json.InstallInfo;
import Json.JsonEditCode;
import common.FileUtils;
import common.Forgeinstall;
import common.Main;
import common.StreamUtils;

/**
 * main code for client install
 * 
 * @author IsaacWheeler
 * 
 */
public class start {

	/**
	 * main function for all client side code, for installing mod pack
	 * 
	 * @throws InterruptedException
	 */
	public static void cstart() throws InterruptedException {
		Main.print("Install Button Clicked");
		Main.print("Begining Install");
		Main.print("Installing client");
		InstallInfo obj = null;
		try {
			obj = GetInstallInfo.JsonInfo();
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			String McVersion = obj.forge().get(0).id();
			McVersion = McVersion.substring(0, 6); // TODO: find better method
			if (!getforgeid.findLastUsedMcVersion().contentEquals(McVersion)) {
				Main.infoBox("Please Run: " + McVersion
						+ " At least once, You Currently Have selected: "
						+ getforgeid.findLastUsedMcVersion()
						+ " Program Exiting", "Warrning");
				Main.print(McVersion + " does not match "
						+ getforgeid.findLastUsedMcVersion());
				Main.exit(0);
			}
			if (getforgeid.findForgeProfile() != null) {
				if (getforgeid.findForgeProfile().contains(
						obj.forge().get(0).id())) { // Possible profile find
													// issue
					Main.print("Forge is already installed moving on to next step");
				} else {
					Forgeinstall.forge(obj.forge().get(0).installer());
				}
			} else {
				Forgeinstall.forge(obj.forge().get(0).installer());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		File AppPath = GetApplicationPath.AppPath();
		File PAQ = new File(AppPath.toString() + "/PAQ/" + Main.instanceName);
		File Mods = new File(PAQ.toString() + "/mods");
		File Config = new File(PAQ.toString() + "/config");

		try {
			FileCreation.FileMake(PAQ, Mods, Config);
		} catch (IOException | InvalidSyntaxException e) {

			e.printStackTrace();
		}
		File config = null;
		try {
			config = File.createTempFile("Config", ".zip");
		} catch (IOException e) {

			e.printStackTrace();
		}
		config.deleteOnExit();
		try (InputStream is = new URL(obj.Config()).openStream()) {
			StreamUtils.saveTo(is, config);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		FileUtils.unzip(config.toString(), Config.toString());

		JOptionPane
				.showMessageDialog(null,
						"About to install mods, the twitching box is to indicate status of download");

		ModsDownload.modsDownload(obj, Mods);

		try {
			JsonEditCode.Main(GetApplicationPath.minecraftpath(),
					PAQ.toString(), obj.forge().get(0).id());
		} catch (IOException | InvalidSyntaxException e) {
			e.printStackTrace();
		}

		Main.print("Client install done");
		Main.infoBox("Install done please enjoy the mod pack","Install Done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Main.exit(0);

	}

}
