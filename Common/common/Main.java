package common;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import server.start;

public class Main {

	public static void main(String[] args) {
		
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
        	start.start(mod,version,preview);
        }else{
        	client.start.start(mod,version,preview);
        }
        
        	

	}

}
