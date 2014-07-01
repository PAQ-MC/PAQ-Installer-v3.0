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
