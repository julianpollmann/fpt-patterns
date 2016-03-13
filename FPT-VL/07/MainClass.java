
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		ArrayList<Topping> toppingList = new ArrayList<Topping>();
		Topping t1 = new Topping("Cheese", true);
		Topping t2 = new Topping("Salami", false);
		toppingList.add(t1);
		toppingList.add(t2);

		// ////////// Get Class-Objects ///////////////

		// Get direct from class //
		Class<Pizza> c1 = Pizza.class;
		System.out.println(c1);

		// Get from an instance of the class //
		Class<?> c2 = new Pizza().getClass();
		System.out.println(c2);

		// Get from the full name //
		try {
			Class<?> c3 = Class.forName("Pizza");
			System.out.println(c3);
			// //// Get all attributes from the class //////
			for (Field f : c3.getFields()) {
				System.out.println("Attribut: " + f.toString());
			}
			// /// Get all constructors from the class /////
			for (Constructor c : c3.getConstructors()) {
				System.out.println("Konstruktor: " + c.toString());
			}
			// /// Get all Methods from the class /////
			for (Method m : c3.getMethods()) {
				System.out.println("Methode: " + m.toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ////////////////////////////////////////

		// Get the constructor from the class with this special signature

		Constructor<Pizza> constructor = c1.getConstructor(String.class,
				double.class, int.class, ArrayList.class);

		// Creating an Object with constructor object
		Pizza myPizza = constructor.newInstance("Schinken", 5.50, 23,
				toppingList);
		// Get the method printPizza from the class
		Method myMethod = c1.getMethod("printPizza");
		myMethod.invoke(myPizza);

		// Get the method setName from the class
		myMethod = c1.getMethod("setName", String.class);
		// Calling the method
		myMethod.invoke(myPizza, "Salami");

		myMethod = c1.getMethod("printPizza");
		myMethod.invoke(myPizza);

	}

}
