package client;

import gui.StdDraw;
import gui.gui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import javax.swing.UIManager;

import Json.GetInstallInfo;
import Json.InstallInfo;
import Json.JsonEditCode;
import common.FileUtils;
import common.Forgeinstall;
import common.StreamUtils;
import common.ModsDownload;

public class start {

	public static void cstart(String mod, String version)
			throws Exception {
		gui.main();
		Gui.consolegui();
		boolean programloop = true;
		while (programloop == true) {

			boolean doLoop = true;
			while (doLoop == true) {
				double x;
				double y;

				if (StdDraw.mousePressed()) {
					x = StdDraw.mouseX();
					y = StdDraw.mouseY();
					// Install
					if (x >= .3 - .3 && x <= .3 + .3) {
						if (y >= .25 - .2 && y <= .25 + .2) {
							System.out.println("Install Button Clicked");
							System.out.println("Begining Install");
							System.out.println("Installing client");
							InstallInfo obj = GetInstallInfo.JsonInfo(version, mod);

							Forgeinstall.forge(false, obj.forge().get(0)
									.installer());

							File AppPath = GetApplicationPath.AppPath();
							File PAQ17X = new File(AppPath.toString()
									+ "/PAQ/PAQ1.7.X");
							File Mods17X = new File(PAQ17X.toString() + "/mods");
							File Config17X = new File(PAQ17X.toString()
									+ "/config");

							FileCreation.FileCreation();
							File config = File.createTempFile("Config", ".zip");
							config.deleteOnExit();
							try (InputStream is = new URL(obj.Config())
									.openStream()) {
								StreamUtils.saveTo(is, config);
							}

							FileUtils.unzip(config.toString(),
									Config17X.toString());

							ModsDownload.modsDownload(obj, Mods17X, true);

							JsonEditCode.Main(AppPath.toString()
									+ "/.minecraft", PAQ17X.toString(), obj
									.forge().get(0).id());

							System.out.println("Client install done");
							Thread.sleep(1000);
							System.exit(0);
						}
					}
					// Exit
					if (x >= .7 - .3 && x <= .7 + .3) {
						if (y >= .25 - .2 && y <= .25 + .2) {
							System.out.println("Exit Button Clicked");
							System.out.println("Exiting");
							System.exit(0);
							doLoop = false;
						}
					}
				}

			}
		}

		while (StdDraw.mousePressed())
			;
	}

}
