package composite;
import java.util.ArrayList;

public class Figure extends Graphic {

	ArrayList<Graphic> list = new ArrayList<Graphic>();

	public Figure() {

	}

	public void draw() {
		for (int i = 0; i < list.size(); i++) {
			this.getChild(i).draw();
		}
	}

	public Graphic getChild(int i) {
		return list.get(i);
	}

	public void addChild(Graphic g) {
		list.add(g);
	}

}
