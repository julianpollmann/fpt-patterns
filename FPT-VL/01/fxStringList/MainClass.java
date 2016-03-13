package fxStringList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	// Eclipse startet JavaFX nicht ohne main methode
	// wird nicht mehr ben�tigt eintritt i.d.r. start s.u.
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// hier die Daten verwalten
		Model model = new Model();

		View view = new View();

		/////Verschiedene L�sungsm�glichkeiten f�r den Controller (nur eine wird ben�tigt) /////

		//L�sung mit Lambda-Ausdruck Controller
		ControllerWithLambda controllerWithLambda = new ControllerWithLambda();
		controllerWithLambda.link(model, view);

		//L�sung ohne Lambda-Ausdruck im Controller
//		ControllerWithoutLambda controllerWithoutLamdba = new ControllerWithoutLambda();
//		controllerWithoutLamdba.link(model, view);

		//L�sung durch die Implemementierung des Interfaces durch den Controller
//		ControllerImplementsInterface controllerImplementsInterface = new ControllerImplementsInterface();
//		controllerImplementsInterface.link(model, view);

		// JavaFX new
		Scene scene  = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
