package View;
import View.Window;

public class Viewer implements Runnable{

	private Window window;
	
	public Viewer(Window window){
		this.window = window;
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	///////////////////////////////// NE FONCTIONNE PAS  (????)
	
	synchronized public void run(){
		while(true){
			try {
				Thread.sleep(100);
			window.update();
				}
				
			 catch (InterruptedException e) {
				e.printStackTrace();
			}
			}}
		
	
	
}
