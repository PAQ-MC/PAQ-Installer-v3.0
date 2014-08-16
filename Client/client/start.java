/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

/***
 Created By Isaac Wheeler
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

public class start {

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
			McVersion = McVersion.substring(0, 5); // TODO: find better method
			if (!getforgeid.findLastUsedMcVersion().contentEquals(McVersion)) {
				Main.infoBox("Please Run: " + McVersion
						+ " At least once, You Currently Have selected: "
						+ getforgeid.findLastUsedMcVersion()
						+ " Program Exiting", "Warrning");
				Main.print(McVersion + " does not match "
						+ getforgeid.findLastUsedMcVersion());
				Main.exit(0);
			}
			try {
				if (getforgeid.findForgeProfile().contains(
						obj.forge().get(0).id())) { // Possible profile find
													// issue
					Main.print("Forge is already installed moving on to next step");
				} else {
					Forgeinstall.forge(false, obj.forge().get(0).installer());
				}
			} catch (Exception e) {
				Forgeinstall.forge(false, obj.forge().get(0).installer());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		File AppPath = GetApplicationPath.AppPath();
		File PAQ17X = new File(AppPath.toString() + "/PAQ/PAQ1.7.X");
		File Mods17X = new File(PAQ17X.toString() + "/mods");
		File Config17X = new File(PAQ17X.toString() + "/config");

		try {
			FileCreation.FileMake();
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

		FileUtils.unzip(config.toString(), Config17X.toString());

		// JOptionPane.showMessageDialog(PAQInstallerV3.window.frame,
		// "About to install mods, the twitching box is to indicate status of download");
		JOptionPane
				.showMessageDialog(null,
						"About to install mods, the twitching box is to indicate status of download");

		ModsDownload.modsDownload(obj, Mods17X, true);

		try {
			JsonEditCode.Main(AppPath.toString() + "/.minecraft",
					PAQ17X.toString(), obj.forge().get(0).id());
		} catch (IOException | InvalidSyntaxException e) {
			e.printStackTrace();
		}

		Main.print("Client install done");
		// JOptionPane.showMessageDialog(PAQInstallerV3.window.frame,
		// "Install done please enjoy the mod pack");
		JOptionPane.showMessageDialog(null,
				"Install done please enjoy the mod pack");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

}
