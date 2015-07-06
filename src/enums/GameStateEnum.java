package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	ANIMATING("animating"),
	START_NEW_ROUND("start new round"),

	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
