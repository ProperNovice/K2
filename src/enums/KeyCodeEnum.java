package enums;

import javafx.scene.input.KeyCode;

public enum KeyCodeEnum {

	FIRST_OPTION(KeyCode.Q), SECOND_OPTION(KeyCode.W);

	private KeyCode keyCode = null;

	private KeyCodeEnum(KeyCode keyCode) {
		this.keyCode = keyCode;
	}

	public KeyCode keyCode() {
		return this.keyCode;
	}

}
