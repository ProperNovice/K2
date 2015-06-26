package enums;

public enum MountaineerEnum {

	I("1"),
	II("2");

	private String fileName = null;

	private MountaineerEnum(String fileName) {
		this.fileName = fileName;
	}
	
	public String fileName() {
		return this.fileName;
	}

}
