package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Menu.fxml"));
		FIBAController fb=new FIBAController();
		fxmload.setController(fb);
		Parent root=fxmload.load();
		Scene scene = new Scene(root,700,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("FIBA");
		primaryStage.setResizable(false);
		fb.loadMenu();


	}

}
