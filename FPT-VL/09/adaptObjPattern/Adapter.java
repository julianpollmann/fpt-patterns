package adaptObjPattern;

public class Adapter implements UsedToBe{

	private Adaptee adaptee;
	
	public Adapter(int number){
		this.adaptee = new Adaptee(number);
	}

	@Override
	public int getNumber() {
		return this.adaptee.getNumberOfCharactersInThisText();
	}
	
	
	
	
}
