package producerConsumerOwnStorage;
public class MainProgram {

	//Beispiel für Erzeuger/Verbraucher mit eingeschränkter Containergröße
	//(notify wird nur vom Producer und Consumer aufgerufen)
	  public static void main(String args[]){
	    Depot depot = new Depot();
	    Producer producer = new Producer(depot);
	    Producer producer2 = new Producer(depot);
	    Consumer consumer = new Consumer(depot);
	    Consumer consumer2 = new Consumer(depot);
	    producer.start();
	    producer2.start();
	    consumer.start();
	    consumer2.start();
	  }

}
