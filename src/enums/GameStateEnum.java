package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	ANIMATING("animating"),
	START_NEW_ROUND("start new round"),
	CHOOSE_CARDS_TO_PLAY("choose cards to play"),
	CHOOSE_MOUNTAINEER_TO_APPLY_CARD("choose mountaineer"),

	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
