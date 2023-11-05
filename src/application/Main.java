package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("RELOJ");
		
		//Image imgLogo = new Image();
		Pane root;
		try {
			root = (Pane)FXMLLoader.load(getClass().getResource("/fxml/Reloj.fxml"));
			Scene scene = new Scene(root,466,400);
			stage.setScene(scene);
			stage.setMinWidth(466);
			stage.setMinHeight(400);
			stage.show();
		} catch (IOException e) {
			System.out.println("La ventana no se abrió correctamente.");
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
