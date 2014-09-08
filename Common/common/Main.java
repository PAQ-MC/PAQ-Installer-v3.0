/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

package common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import server.start;

/**
 * Main Start Class handles functions used thru out program + start point for
 * whole program
 * 
 * @author Isaac
 * 
 */
public class Main {

	// String for location of installer info
	public static String mod;
	// String to decide which version to use
	public static String version;
	// String to decide instance name
	public static String instanceName;

	static PrintWriter out;

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException,
			IllegalAccessException, IOException, InterruptedException {

		// Setting up Log File

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		out = new PrintWriter(new FileWriter("PAQlog "
				+ dateFormat.format(date) + ".txt"), true);
		Main.print("Current System os is : "
				+ System.getProperty("os.name").toLowerCase());

		// reading argments

		OptionParser parser = new OptionParser("m::v::s::h::i");
		OptionSet options = parser.parse(args);


		if (options.has("m")) {
			mod = (String) options.valueOf("m");
			print((String) options.valueOf("m"));
		} else{
			mod = "http://mage-tech.org/PAQ/versioninfo.json";
			print(mod);
		}
		if (options.has("v")) {
			version = (String) options.valueOf("v");
			print((String) options.valueOf("v"));
		}
		if (options.has("i")) {
			instanceName = (String) options.valueOf("i");
			print((String) options.valueOf("i"));
		} else {
			instanceName = "PAQ";
		}
		boolean server = options.has("s");

		// help argment

		if (options.has("h")) {
			print("Argement help");
			System.out.println("--m = modpack location in fourm of url");
			System.out
					.println("--v = modpack version only for debuging don't use unless you know what your doing ");
			System.out.println("--s = is this a server install");
			System.out.println("--h = this help menu");
			exit(0);
		}

		// checking if server argement is true

		if (server == true) {
			try {
				start.svstart();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				infoBox("Starting PAQ Client Install please close this box to start",
						"start message");
				client.start.cstart();
				// PAQInstallerV3.main();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 *  main print class for use with logger
	 * @param msg the message you want printed
	 */
	public static void print(String msg) {
		System.out.println(msg);
		out.println(msg);
		out.flush();
	}

	/**
	 * main exit class closes log file before exiting
	 * @param status if program is exiting with error or not 
	 */
	public static void exit(int status) {
		out.close();
		System.exit(status);
	}

	/**
	 * message box pop up
	 * @param infoMessage message that you want shown
	 * @param location location that it is called from (not used often)
	 */
	public static void infoBox(String infoMessage, String location) {
		JOptionPane.showMessageDialog(null, infoMessage,
				"InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	}
}
