/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package Json;

public class version {

	private int major;
	private int minor;
	private int build;

	@Override
	public String toString() {
		return major + "." + minor + "."
				+ build;
	}

	public int major() {
		return major;
	}
	
	public int minor() {
		return minor;
	}
	
	public int build() {
		return build;
	}
}
