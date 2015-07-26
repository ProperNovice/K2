package enums;

public enum TextEnum {
	
	CHOOSE_CARD_TO_PLAY("Choose card\nto play", TextTypeEnum.INDICATOR),
	MOUNTAINEER_I("M. I", TextTypeEnum.OPTION),
	MOUNTAINEER_II("M. II", TextTypeEnum.OPTION),
	UP("Up", TextTypeEnum.OPTION),
	DOWN("Down", TextTypeEnum.OPTION),
	CHOOSE_RISK_TOKEN("Choose\nrisk token", TextTypeEnum.INDICATOR),
	APPLY_RISK_TOKEN("Apply\nrisk token", TextTypeEnum.INDICATOR),
	MOVE_MOUNTAINEER_I("Move m. I", TextTypeEnum.INDICATOR),
	MOVE_MOUNTAINEER_II("Move m. II", TextTypeEnum.INDICATOR),
	CONTINUE("Continue", TextTypeEnum.OPTION),
	PLACE_TENT("Place tent", TextTypeEnum.OPTION),
	END_TURN("End turn", TextTypeEnum.OPTION),
	RESTART_TURN("Restart turn", TextTypeEnum.OPTION),
	START_GAME("Start game", TextTypeEnum.OPTION),
	CHOOSE_DIFFICULTY_MAP("Choose difficulty map", TextTypeEnum.INDICATOR),
	EASY("Easy", TextTypeEnum.OPTION),
	HARD("Hard", TextTypeEnum.OPTION),
	CHOOSE_DIFFICULTY_WEATHER("Choose difficulty weather", TextTypeEnum.INDICATOR),
	SUMMER("Summer", TextTypeEnum.OPTION),
	WINTER("Winter", TextTypeEnum.OPTION),
	END_GAME("End game", TextTypeEnum.OPTION),
	YOU_WON("You won", TextTypeEnum.INDICATOR),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR),
	RESTART_GAME("Restart", TextTypeEnum.OPTION),
	
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
