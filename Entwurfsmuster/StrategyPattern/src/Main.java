
public class Main {


	public static void main(String[] args) {

		int result;

		// Kontext erzeugen + Strategie als Parameter übergeben
		// executeStrategy in Context Object ausführen
		Context con = new Context(new OperationAdd());
		result = con.executeStrategy(3, 4);
		System.out.println(result);

		// Strategy wechseln
		con.setStrategy(new OperationMultiply());
		result = con.executeStrategy(3, 4);
		System.out.println(result);

	}

}
