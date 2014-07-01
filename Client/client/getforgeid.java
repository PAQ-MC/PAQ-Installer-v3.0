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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class getforgeid {
	
	public static final String MINECRAFT_LAUNCHER_PROFILES = "launcher_profiles.json";
	
	public static String findForgeProfile() throws IOException {
        File configFile = getConfigFile();

        Gson gson = GsonUtil.make();
        JsonObject jobj;
        try (InputStream is = new FileInputStream(configFile);
            InputStreamReader isr = new InputStreamReader(is)) {
            jobj = gson.fromJson(isr, JsonElement.class).getAsJsonObject();
        }

        JsonObject profiles = jobj.getAsJsonObject("profiles");
        JsonObject forge = profiles.getAsJsonObject("Forge");
        if(forge == null)
            return null;

        return forge.getAsJsonPrimitive("lastVersionId").getAsString();
    }
	
	private static File getConfigFile() throws IOException {
        String minecraftInstall = GetApplicationPath.AppPath() + "/.minecraft/";
        if(!new File(minecraftInstall).exists()) {
            throw new IllegalStateException("Minecraft not found");
        }

        File configFile = new File(minecraftInstall +  MINECRAFT_LAUNCHER_PROFILES);
        if(!configFile.exists()) {
            throw new IllegalStateException("Minecraft " + MINECRAFT_LAUNCHER_PROFILES + " not found");
        }

        return configFile;
    }
	
	

}
