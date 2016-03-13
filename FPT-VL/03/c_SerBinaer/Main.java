package c_SerBinaer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// // Create Objects ////

		ArrayList<Topping> toppingList = new ArrayList<Topping>();
		Topping t1 = new Topping("Cheese", true);
		Topping t2 = new Topping("Salami", false);
		toppingList.add(t1);
		toppingList.add(t2);
		// Object to serialize
		Pizza p1 = new Pizza("Salami", 5.50, 23, toppingList);

		// // Serialize ////
		try (FileOutputStream fo = new FileOutputStream("binSer.ser");
				ObjectOutputStream os = new ObjectOutputStream(fo)) {
			os.writeObject(p1); // write Object
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// // Deserialize ////
		Pizza readObject = null;

		try (FileInputStream fi = new FileInputStream("binSer.ser");
				ObjectInputStream is = new ObjectInputStream(fi)) {
			readObject = (Pizza) is.readObject(); // Read Object

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readObject.printPizza();

	}
}
