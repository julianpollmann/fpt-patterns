package x_eigenes;

public class Bank {

	private int depot;

	public Bank (){
		depot = 3000;
	}

	public synchronized int abheben(int i){
		if (depot - i > 0){
			depot -= i;
			return i;
		}
		System.out.println("Konto überzogen");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized void draufZahlen(int i){
		depot += i;
		notify();
	}

	public int getDepot() {
		return this.depot;
	}

}
