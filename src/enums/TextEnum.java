package enums;

import controller.TextController.TextTypeEnum;

public enum TextEnum {

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
