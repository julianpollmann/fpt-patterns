package composite;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graphic g1 = new Line();
		Graphic g2 = new Rectangle();
		Graphic g3 = new Line();
		Graphic g4 = new Figure();
		Graphic g5 = new Figure();
		
		g4.addChild(g1);
		g4.addChild(g2);
		g4.addChild(g3);
		g5.addChild(g4);
		g5.addChild(g2);
		
		System.out.println("---------G1-------------");
		g1.draw();
		System.out.println("---------G2-------------");
		g2.draw();
		System.out.println("---------G3-------------");
		g3.draw();
		System.out.println("---------G4-------------");
		g4.draw();
		System.out.println("---------G5-------------");
		g5.draw();
		

	}

}
