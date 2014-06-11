package common;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.swing.UIManager;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import server.start;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InterruptedException {
		
        
        
		
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
        	try {
				start.svstart(mod,version,preview);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else{
        	try {
        		client.start.cstart(mod,version,preview);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        	

	}

}
