package enums;

public enum TextEnum {
	
	CHOOSE_CARDSTO_PLAY("Choose cards\nto play", TextTypeEnum.INDICATOR),
	MOUNTAINEER_I("Mountaineer I", TextTypeEnum.OPTION),
	MOUNTAINEER_II("Mountaineer II", TextTypeEnum.OPTION),

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
