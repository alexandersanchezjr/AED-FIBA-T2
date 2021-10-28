package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.FIBA;

public class Main extends Application {

	private FIBAController fibaController;
    private FIBA fiba;

    public Main() {
    
            fiba = new FIBA();
      
        fibaController=new FIBAController(fiba);
    }




	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Pane.fxml"));
		fxmload.setController(fibaController);
		Parent root=fxmload.load();
		Scene scene = new Scene(root,700,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("FIBA");
		primaryStage.setResizable(false);

		Image icon = new Image("resources/FIBA-logo.png");
		primaryStage.getIcons().add(icon);
		fibaController.loadMenu();


	}

}
