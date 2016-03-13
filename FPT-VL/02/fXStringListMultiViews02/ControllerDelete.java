package fXStringListMultiViews02;

public class ControllerDelete {

	public void link(Model model, AlterView view) {
		view.getList().setItems(model.getStrings());
		view.addEventHandler(e -> {
			model.delete();
		});
	}

}
