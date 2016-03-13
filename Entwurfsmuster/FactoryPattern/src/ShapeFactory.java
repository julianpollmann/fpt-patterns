
public class ShapeFactory {

	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}

	public Shape createShape(String shapeType) {

		switch(shapeType) {
			case "Circle":
				return new Circle();
			case "Rectangle":
				return new Rectangle();
		}

		return null;
	}

}
