package com.vibridi.jupper;

import com.vibridi.fxmlutils.FXUtils;

import com.vibridi.jupper.utils.AppContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

	public static void main(String[] args) {
		launch();
	}

	public JavaFXApplication() throws Exception {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		FXUtils.newView(this.getClass(), "view/mainview.fxml")
			.makeStage("jupper " + AppContext.VERSION_NUMBER)
			.build()
			.show();
	}

}

