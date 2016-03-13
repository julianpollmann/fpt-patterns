package mvcfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller();
		controller.link(model, view);
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
