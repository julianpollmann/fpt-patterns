package DeepCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Point> points = new ArrayList<Point>();
		// Add Points into Array List
		points.add(new Point(2, 2));
		points.add(new Point(1, 3));
		points.add(new Point(1, 4));

		// Creating a flat copy of the ArrayList
		ArrayList<Point> flatCopy = (ArrayList<Point>) points.clone();
		// Creating a deep copy of the ArrayList
		ArrayList<Point> deepCopy = null;
		try {
			deepCopy = (ArrayList<Point>) deepCopy(points);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Change the x value of the original of the first point
		points.get(0).x = 5;
		// Change the y value of the deep copy of the first point
		deepCopy.get(0).y = 6;

		// Printing the ArrayLists
		System.out.println("Original:");
		for (Point p : points) {
			p.printPoint();
		}

		System.out.println("flatCopy:");
		for (Point p : flatCopy) {
			p.printPoint();
		}

		System.out.println("deepCopy:");
		for (Point p : deepCopy) {
			p.printPoint();
		}

	}

	public static Object deepCopy(Object o) throws IOException {

		try (FileOutputStream fos = new FileOutputStream("tmpObj");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(o);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object deepCpy = null;
		// Deserialize object
		try (FileInputStream fis = new FileInputStream("tmpObj");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			deepCpy = (Object) ois.readObject();
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return deepCpy;
	}

	public static Object deepBufferedCopy(Object o) throws IOException {
		// Serialize object
		byte[] daten = null;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(o);
			oos.flush();
			daten = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object deepCpy = null;

		// Deserialize object
		try (ByteArrayInputStream bin = new ByteArrayInputStream(daten);
				ObjectInputStream ois = new ObjectInputStream(bin)) {

			deepCpy = (Object) ois.readObject();
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return deepCpy;
	}

}
