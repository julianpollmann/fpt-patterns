package adapterClass;

public class Adapter extends Adaptee implements UsedToBe{

	public Adapter(int number){
		super(number);
	}
	
	public int getNumber(){
		return this.getNumberOfCharactersInThisText();
	}
}
