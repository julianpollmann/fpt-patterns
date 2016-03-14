import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Model model;
	private View view;

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public void link(Model model, View view) {
		this.model = model;
		this.view = view;

		this.model.addObserver(view);
		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.addString(view.getInputPaneText());
	}

}
