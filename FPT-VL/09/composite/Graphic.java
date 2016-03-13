package composite;

public abstract class Graphic {

	public abstract void draw();
	public abstract void addChild(Graphic g);
	public abstract Graphic getChild(int i);
}
