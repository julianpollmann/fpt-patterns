package mvcfx;

import java.util.ArrayList;

public class Model extends ArrayList<String>{

	public void addText(String text) {
		
		this.add(text);
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.get(i)+" ");
			
		}
		System.out.println("");
	}

}
