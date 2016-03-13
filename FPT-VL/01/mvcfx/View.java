package mvcfx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane{

	TextField tf;
	Button b;

	public View(){
		tf=new TextField("");
		b=new Button("Press to boom");
		setTop(tf);
		setCenter(b);
	}

	public void addBoomEvent(BoomListener boom){
		b.setOnAction(e-> {
			boom.addText();
		});
	}
}
