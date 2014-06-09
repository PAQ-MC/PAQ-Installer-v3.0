package common;

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
