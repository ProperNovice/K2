package enums;

public enum TextEnum {
	
	CHOOSE_CARD_TO_PLAY("Choose card\nto play", TextTypeEnum.INDICATOR),
	MOUNTAINEER_I("M. I", TextTypeEnum.OPTION),
	MOUNTAINEER_II("M. II", TextTypeEnum.OPTION),
	UP("Up", TextTypeEnum.OPTION),
	DOWN("Down", TextTypeEnum.OPTION),
	CHOOSE_RISK_TOKEN("Choose\nrisk token", TextTypeEnum.INDICATOR),
	APPLY_RISK_TOKEN("Apply\nrisk token", TextTypeEnum.INDICATOR),

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
