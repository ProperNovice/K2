package gui;

import instances.Instances;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.Logger;
import utils.ShutDown;
import enums.Dimensions;

public class K2 extends Application {

	private Panel panel = null;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Animation.startAnimation();
		Logger.startLogging();

		this.panel = new Panel();

		double width = Dimensions.FRAME.x() + Dimensions.INSETS.x();
		double height = Dimensions.FRAME.y() + Dimensions.INSETS.y();

		Scene scene = new Scene(this.panel);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				Instances.getControllerInstance().gameStateController()
						.handleKeyPressed(event.getCode());
			}
		});

		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle("K2");

		primaryStage
				.setX((Screen.getPrimary().getBounds().getWidth() - width) / 2 - 45);
		primaryStage.setY(6);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.execute();
			}

		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
