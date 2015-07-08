package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	ANIMATING("animating"),
	START_NEW_ROUND("start new round"),
	CHOOSE_CARD_TO_PLAY("choose card to play"),
	CHOOSE_MOUNTAINEER_TO_APPLY_CARD("choose mountaineer"),
	CHOOSE_ROPE_DIRECTION("choose rope direction"),
	CHOOSE_RISK_TOKEN("choose risk token"),

	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
