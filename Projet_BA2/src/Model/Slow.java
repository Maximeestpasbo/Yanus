package Model;
 
 public class Slow implements Runnable{
 	private int iteration;
 	private int slowTime;
 	private Living living;
 	private int range; 
 	
 	public Slow(int itération, int slowTime, Living living, int range){
 		this.slowTime = slowTime;
 		this.range= range;
 		this.iteration = itération;
 		this.living = living;
 		Thread t1 = new Thread(this);
 		t1.start();
 	}
 	
 	@Override
 	public void run(){
 		int count02 = 0;
 		living.setTimeTS(slowTime);
 		System.out.println("living TimeTS = " +living.getTimeTS());
 		
 		while (count02< iteration){
 			try{
 				Thread.sleep(500);
 				count02 = count02+1;
 				System.out.println("count02 = " + count02);
 				
 				
 			}
 			catch(Exception e){
 				
 			}
 		}
 		living.setTimeTS(living.getTrueTimeTS());
 		
 	}
 	
 	
 }