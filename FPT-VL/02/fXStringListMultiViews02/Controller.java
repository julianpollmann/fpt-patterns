package fXStringListMultiViews02;

public class Controller {

	public void link(Model model, View view) {
		view.getList().setItems(model.getStrings());
		view.addEventHandler(e -> {
			model.addString(view.getInputPaneText());
		});
	}

}
