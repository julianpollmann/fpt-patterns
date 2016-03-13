package mvc_owntry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller();
		c.link(v, m);
		Scene scene = new Scene(v);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}