package stringListMultiViews01;

public class MainClass {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		AlterView view2 = new AlterView();
		Controller controller = new Controller();
		controller.link(model, view);
		ControllerDelete controller2 = new ControllerDelete();
		controller2.link(model,view2);

	}

}
