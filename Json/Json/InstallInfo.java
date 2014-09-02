/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package Json;

import java.util.List;

public class InstallInfo {
	private String Config;
	private List<forge> Forge;
	private List<version> version;
	private List<mods> mods;

	

	@Override
	public String toString() {
		return "DataObject  " + version() + mods + "";
	}
	
	public List<version> version() {
		return version;
	}
	
	public List<mods> mods() {
		return mods;
	}
	
	public String Config(){
		return Config;
	}

	public List<forge> forge(){
		return Forge;
	}
}
