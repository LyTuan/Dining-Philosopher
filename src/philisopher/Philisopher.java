package philisopher;

import java.util.Random;

public class Philisopher implements Runnable {
	private int  idPhilisopher;
	Chopstick left;
	Chopstick right;
	Random random = new Random();
	public Philisopher(int idPhilisopher, Chopstick left, Chopstick right){
		this.idPhilisopher = idPhilisopher;
		this.left = left;
		this.right = right;
	}
	public void eat() throws InterruptedException{
		System.out.println("Philisopher"+this.idPhilisopher+" is eating.");
		Thread.sleep(1+random.nextInt(5000));
	}
	
	public void think() throws InterruptedException{
		System.out.println("Philisopher"+this.idPhilisopher+" is thinking.");
		Thread.sleep(1+random.nextInt(3000));
	}
	
	public void hungry() throws InterruptedException{
		System.out.println("Philisopher"+this.idPhilisopher+" is hungry.");
		Thread.sleep(1+random.nextInt(6000));
	}

	public void waitState() throws InterruptedException{
		if(idPhilisopher %2==0){
			hungry();
			left.getChopstick();
			Thread.sleep(500);
			eat();
			right.getChopstick();
		}else{
			hungry();
			right.getChopstick();
			Thread.sleep(500);
			eat();
			right.getChopstick();
		}
		
	}
	
	public void signal(){
		left.putChopstick();
		right.putChopstick();
	}
	public void run() {
		try{
			while(true){
				think();
				
				waitState();
				
				signal();
			}
		}catch(InterruptedException e){
			
		}
	}
	
}
