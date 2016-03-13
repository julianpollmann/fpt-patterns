package fXStringList_02;
import javafx.scene.control.ListCell;

public class MyCustomCell extends ListCell<String> {

	@Override
	protected void updateItem(String myObject, boolean b) {
		super.updateItem(myObject, myObject == null || b);
		if (myObject != null) {
			setText("..." + myObject + "...");
		} else {
			// wichtig da sonst der text stehen bleibt!
			setText("");
		}
	}

}