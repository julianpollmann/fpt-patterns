
public class Main {

	// Siehe http://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
	public static void main(String[] args) {

		Image image = new ProxyImage("Test");
		image.display();
	}

}
