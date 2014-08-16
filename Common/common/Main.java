/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
 */

/***
 Created By Isaac Wheeler
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

public class Main {

	public static String _mod;
	public static String _version;

	static PrintWriter out;

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException,
			IllegalAccessException, IOException, InterruptedException {
		
		//Setting up Log File

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		out = new PrintWriter(new FileWriter("PAQlog "
				+ dateFormat.format(date) + ".txt"), true);
		Main.print("Current System os is : " + System.getProperty("os.name").toLowerCase() ); 
		

		//reading argments
		
		OptionParser parser = new OptionParser("m::v::s::h");
		OptionSet options = parser.parse(args);

		String mod = null;
		String version = null;
		boolean server = false;

		if (options.has("m")) {
			mod = (String) options.valueOf("m");
			print((String) options.valueOf("m"));
		}
		if (options.has("v")) {
			version = (String) options.valueOf("v");
		}
		server = options.has("s");

		//help argment
		
		if (options.has("h")) {
			print("Argement help");
			System.out.println("--m = modpack location in fourm of url");
			System.out
					.println("--v = modpack version only for debuging don't use unless you know what your doing ");
			System.out.println("--s = is this a server install");
			System.out.println("--h = this help menu");
			exit(0);
		}
		
		//checking if server argement is true

		if (server == true) {
			try {
				_mod = mod;
				_version = version;
				start.svstart(mod, version);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				_mod = mod;
				_version = version;
				infoBox("Starting PAQ Client Install please close this box to start","start message");
				client.start.cstart();
				//PAQInstallerV3.main();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
	//main print class for use with logger
	public static void print(String msg) {
		System.out.println(msg);
		out.println(msg);
		out.flush();
	}

	//main exit class closes log file before exiting
	public static void exit(int status) {
		out.close();
		System.exit(status);
	}
	
	//message box pop up
	public static void infoBox(String infoMessage, String location) {
		JOptionPane.showMessageDialog(null, infoMessage,
				"InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	}
}
