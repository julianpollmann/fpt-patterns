package mvc_owntry;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane{

	TextField tf;
	Button b;

	public View(){
		tf=new TextField("");
		b=new Button("Print");
		setTop(tf);
		setCenter(b);
	}

}
