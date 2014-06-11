package Json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

import argo.format.PrettyJsonFormatter;
import argo.jdom.JdomParser;
import argo.jdom.JsonField;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.saj.InvalidSyntaxException;


public class JsonEditCode {

    public static void Main(String jsonlocation, String gameDir, String forgeid) throws IOException, InvalidSyntaxException
    {
        
        File launcherProfiles = new File(jsonlocation + "/launcher_profiles.json");
        if (!launcherProfiles.exists())
        {
        	System.out.println("minecraft launcher profile missing, you need to run the minecraft launcher first!");
        }
  
        JdomParser parser = new JdomParser();
        JsonRootNode jsonProfileData;
        jsonProfileData = parser.parse(Files.newReader(launcherProfiles, Charsets.UTF_8));

        //PAQ Profile setup location
        
        JsonField[] fields = new JsonField[] {
            JsonNodeFactories.field("name", JsonNodeFactories.string("PAQ")),
            JsonNodeFactories.field("gameDir", JsonNodeFactories.string(gameDir)),            
            JsonNodeFactories.field("lastVersionId", JsonNodeFactories.string(forgeid)),
            JsonNodeFactories.field("javaArgs", JsonNodeFactories.string("-Xmx1G -XX:PermSize=1024m")),
            JsonNodeFactories.field("useHopperCrashservice",JsonNodeFactories.booleanNode(false)),
            JsonNodeFactories.field("launcherVisibilityOnGameClose", JsonNodeFactories.string("keep the launcher open")),
            
        };

        HashMap<JsonStringNode, JsonNode> profileCopy = Maps.newHashMap(jsonProfileData.getNode("profiles").getFields());
        HashMap<JsonStringNode, JsonNode> rootCopy = Maps.newHashMap(jsonProfileData.getFields());
        profileCopy.put(JsonNodeFactories.string("PAQ"), JsonNodeFactories.object(fields)); //add PAQ + v. number to the Text Text field at this location
        JsonRootNode profileJsonCopy = JsonNodeFactories.object(profileCopy);

        rootCopy.put(JsonNodeFactories.string("profiles"), profileJsonCopy);

        jsonProfileData = JsonNodeFactories.object(rootCopy);


            BufferedWriter newWriter = Files.newWriter(launcherProfiles, Charsets.UTF_8);
            PrettyJsonFormatter.fieldOrderPreservingPrettyJsonFormatter().format(jsonProfileData,newWriter);
            newWriter.close();
        }
    }

