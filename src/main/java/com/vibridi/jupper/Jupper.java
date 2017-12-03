package com.vibridi.jupper;

import com.vibridi.fxu.builder.FXBuilder;

import javafx.application.Application;
import javafx.stage.Stage;

public class Jupper extends Application {

	public static String defaultClass = "";
	public static String defaultMethod = "";
	
	public Jupper() {
	}
	
	public static void profile() {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		FXBuilder.newView(this.getClass(), "view/mainview.fxml")
			.makeStage("jupper")
			.setupWith(defaultClass, defaultMethod)
			.build()
			.show();
	}

}

