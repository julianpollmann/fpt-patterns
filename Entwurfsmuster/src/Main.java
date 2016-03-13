
public class Main {

	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();

		Shape circle = sf.createShape("Circle");
		circle.draw();

		Shape rect = sf.createShape("Rectangle");
		rect.draw();
	}

}
