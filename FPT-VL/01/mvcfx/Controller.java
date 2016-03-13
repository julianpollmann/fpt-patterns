package mvcfx;

public class Controller {

	public void link(Model model, View view) {
		view.addBoomEvent(()->{
			model.addText(view.tf.getText());
		});

	}

}
