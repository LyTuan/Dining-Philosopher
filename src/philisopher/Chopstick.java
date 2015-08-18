package philisopher;

public class Chopstick {
	private int idNumber;
	private boolean take = false;
	Chopstick(int idNumber){
		this.idNumber = idNumber;
	}
	synchronized void getChopstick() throws InterruptedException{
		while(take){
			wait();
		}
		take = true;
	}
	synchronized void putChopstick(){
		take = false;
		notify();
	}
}
