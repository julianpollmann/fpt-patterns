
public class ProxyImage implements Image {

	private RealImage realimage;
	private String filename;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if(realimage == null) {
			realimage = new RealImage(this.filename);
		}
		realimage.display();
	}

}
