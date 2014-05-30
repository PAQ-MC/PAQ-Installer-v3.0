package common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import server.start;

public class Main {
	
	public static String ForgePath = "http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.7.2-10.12.1.1101/forge-1.7.2-10.12.1.1101-installer.jar";

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
		
		OptionParser parser = new OptionParser("m::v::p::s");
        OptionSet options = parser.parse(args);
        
        String mod = "PAQ";
        String version = null;
        boolean preview = false;
        boolean server = false;

        if(options.has("m")){
            mod = (String)options.valueOf("m");
        }
        if(options.has("v")){
            version = (String)options.valueOf("v");
        }
        preview = options.has("p");
        server = options.has("s");
        
        if (server == true){
        	start.svstart(mod,version,preview);
        }else{
        	client.start.cstart(mod,version,preview);
        }
        
        	

	}

}
