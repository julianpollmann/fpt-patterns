package x_eigenes;

public class Inhaber extends Thread {

	int geld = 0;
	private Bank bank;
	private int name;

	public Inhaber(int name, Bank b){
		this.name = name;
		this.bank = b;
	}

	public void run() {
		while (true) {
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int betrag = (int) (Math.random()*300);
			geld += bank.abheben(betrag);
			System.out.println("Inhaber "+ name +" nimmt Betrag " + betrag + ",- und hat Kontostand: " + geld + ",-");
		}
	}

}
