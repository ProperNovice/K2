package enums;

public enum TextEnum {
	
	CHOOSE_A_CARD("Choose card", TextTypeEnum.INDICATOR),
	MOUNTAINEER_I("M. I", TextTypeEnum.OPTION),
	MOUNTAINEER_II("M. II", TextTypeEnum.OPTION),
	UP("Up", TextTypeEnum.OPTION),
	DOWN("Down", TextTypeEnum.OPTION),

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

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
