package common;

import Json.version;

import java.util.List;

public class Versioninfo {

	private String InstallInfoDirectory;
	private List<version> versions;

	public List<version> versions() {
		return versions;
	}

	public String InstallInfoDirectory() {
		return InstallInfoDirectory;
	}
}
