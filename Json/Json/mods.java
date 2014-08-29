/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package Json;

public class mods {

	private String FileName;
	private String link;
	private int id;
	private boolean adfly;
	private boolean ClientOnly;
	private long FileSize;

	@Override
	public String toString() {
		return "FileName= " + FileName + " link= " + link + " id= " + id + " adfly= "
				+ adfly;
	}
	
	public String name(){ //TODO:Update Rest of code for FileName 
		return FileName;
	}
	
	public String link() {
		return link;
	}
	
	public int id() {
		return id;
	}
	
	public boolean adfly() {
		return adfly;
	}
	
	public boolean ClientOnly(){
		return ClientOnly;
	}
	
	public long FileSize() {
		return FileSize;
	}
}
