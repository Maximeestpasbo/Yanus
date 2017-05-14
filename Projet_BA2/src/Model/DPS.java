package Model;

public class DPS  implements Runnable{
	private int iteration;
	private int degats;
	private Living living;
	private int range; 
	
	public DPS(int itération, int degats, Living living, int range){
		this.degats = degats;
		this.range= range;
		this.iteration = itération;
		this.living = living;
		Thread t1 = new Thread(this);
		t1.start();
	}
	



	@Override
	public void run() {
		int i = 0;
		while (i< iteration){
		try{ 
			Thread.sleep(1000);
			living.Hit(degats);
			i++;
			//System.out.println(i);
			//System.out.println(living.getLp()+"    DPS");
			
		}
		 catch (InterruptedException e) {
				e.printStackTrace();
		
		
		}
	

}
	}}