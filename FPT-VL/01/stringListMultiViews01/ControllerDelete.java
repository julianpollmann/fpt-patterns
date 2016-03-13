package stringListMultiViews01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDelete implements ActionListener {

	private Model model;
	private AlterView view;

	public ControllerDelete() {

	}

	public void actionPerformed(ActionEvent arg0) {
		model.delete();

	}

	public void link(Model m, AlterView v){
		this.model = m;
		this.model.addObserver(v);

		this.view = v;
		view.addActionListener(this);
	}

}
