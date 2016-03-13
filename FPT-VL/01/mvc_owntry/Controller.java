package mvc_owntry;

public class Controller {

	public void link(View v, Model m) {
		v.b.setOnAction(e -> {
			m.writeText(v.tf.getText());
		});
	}

}
