package com.proyecto.javafx.app;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
	
	public class App extends Application {
		@Override
		public void start(Stage primaryStage) {

			primaryStage.setTitle("Base de datos ViedoJuegos");
			Pane ventanaPane;		
			
			FXMLLoader loader = new FXMLLoader();
			URL xmlUrl = App.class.getResource("/com/proyecto/javafx/vista/Juegos.fxml");
			loader.setLocation(xmlUrl);
			try {
				ventanaPane = loader.load();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
				ventanaPane = null;
			}

			Scene primaryScene = new Scene(ventanaPane, 800, 500);
			primaryStage.setScene(primaryScene);
			primaryStage.show();

		}

		public static void main(String[] args) {
			Application.launch();
		}

}
