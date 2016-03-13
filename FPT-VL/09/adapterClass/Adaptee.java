package adapterClass;

public class Adaptee {

	private int number;
	
	
	public Adaptee(int number){
		this.number = number;
	}
	
	//Methodenname zu lang neues Interface
	public int getNumberOfCharactersInThisText(){
		return this.number;
	}
	
}
