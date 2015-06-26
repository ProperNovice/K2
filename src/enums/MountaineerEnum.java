package enums;

public enum MountaineerEnum {

	I("I"),
	II("II");

	private String fileName = null;

	private MountaineerEnum(String fileName) {
		this.fileName = fileName;
	}
	
	public String fileName() {
		return this.fileName;
	}

}
