package philisopher;

public class Main {
	public static void main(String avgs[]){
		Thread [] philisopher = new Thread[5];
		Chopstick chopstick[] =new Chopstick[5];
		for(int pos=0; pos<5;pos++){
			chopstick[pos] = new Chopstick(pos);
		}
		for(int pos =0 ; pos<5; pos++){
			Philisopher ps= new Philisopher(pos,chopstick[((pos+4)%5)],chopstick[pos]);
			philisopher[pos]  = new Thread(ps);
			philisopher[pos].start();
		}
	}
}
