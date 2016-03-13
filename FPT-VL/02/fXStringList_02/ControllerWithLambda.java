package fXStringList_02;


public class ControllerWithLambda {

	public void link(Model model, View view) {
		//Verbidung zwischen den Daten im Model und der Liste in der View.
		//Die Liste wird automatisch �ber �nderungen informiert und aktualisiert sich.
		view.getList().setItems(model.getStrings());
		//Seit Java 1.8 k�nnen Lambda-Ausdr�cke verwendet werden.
		//Da EventHandler ein funktionales Interface ist (besitzt nur eine Methodensignatur),
		//kann hier elegant mit Lambda-Ausdr�cken gearbeitet werden.
		view.addEventHandler(e -> {
			model.addString(view.getInputPaneText());
		});
	}

}
