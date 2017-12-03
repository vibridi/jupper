package com.vibridi.jupper.controller;

import java.lang.reflect.Method;

import com.vibridi.fxu.controller.BaseController;
import com.vibridi.fxu.dialog.FXDialog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

public class JupperViewController extends BaseController {
	
	@FXML private TextField classField; 
	@FXML private TextField methodField;
	@FXML private Label msgLabel;
	
	public JupperViewController() {
	}
	
	@FXML 
	public void initialize() {
		msgLabel.setText("");
	}
	
	@Override
	public void setupWith(Object... parameters) {	
		if(parameters.length > 0 && parameters[0] instanceof String) {
			classField.setText((String) parameters[0]);
		}
		
		if(parameters.length > 1 && parameters[1] instanceof String) {
			methodField.setText((String) parameters[1]);
		}
	}
	
	@FXML
	public void launchTest() {
		msgLabel.setText("");
		msgLabel.setTextFill(Color.BLACK);

		String clazz = classField.getText();
		String method = methodField.getText();
		
		if(clazz.isEmpty() || method.isEmpty()) {
			msgLabel.setTextFill(Color.RED);
			msgLabel.setText("Class and method fields may not be empty");
			return;
		} 
		
		try {
			Object testClass = Class.forName(clazz).getConstructor().newInstance();
			Method testMethod = testClass.getClass().getMethod(method);
			long start = System.currentTimeMillis();
			testMethod.invoke(testClass);
			long end = System.currentTimeMillis() - start;
			msgLabel.setText("Test completed in " + end + " millis.");
			
		} catch(Throwable e) {
			FXDialog.errorAlert("Test failed", e).showAndWait();
		}
	}
	
	@Override
	protected void handleCloseRequest(WindowEvent arg0) {
		System.out.println("Jupper test finished");
	}
}
