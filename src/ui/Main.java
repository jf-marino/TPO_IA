package ui;
	
import integracion.ClipsHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			System.loadLibrary("CLIPSJNI");
			Parent root = FXMLLoader.load(getClass().getResource("norber.fxml"));
			Scene scene = new Scene(root,1200,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Primeros Auxilios");
			primaryStage.setOnCloseRequest(e -> onClose());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void onClose() {
		ClipsHandler clips = ClipsHandler.get();
		clips.close();
	}
}
