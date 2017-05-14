package Model;

public class Slow implements Runnable{
	private int effet;
	private Living o;
	private int duree;
	private int count = 0;
	
	public Slow(Living o, int effet, int duree){
		this.effet = effet;
		this.duree = duree;
		this.o = o;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		int oldTimeTS = o.getTimeTS();
		o.setTimeTS(effet);
		while(count < duree){
			try {
				Thread.sleep(1000);
				count += 1;
				} 
				
			 catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		o.setTimeTS(oldTimeTS);
		}
	

}
