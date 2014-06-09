package common;

public class mods {

	private String name;
	private String link;
	private int id;
	private boolean adfly;
	private boolean ClientOnly;
	private long FileSize;

	@Override
	public String toString() {
		return "name= " + name + " link= " + link + " id= " + id + " adfly= "
				+ adfly;
	}
	
	public String name(){
		return name;
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
