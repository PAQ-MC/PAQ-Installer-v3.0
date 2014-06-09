package common;

import common.mods;
import common.version;

import java.util.List;

public class InstallInfo {
	private String Config;
	private List<version> version;
	private List<mods> mods;

	

	// getter and setter methods

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
}
