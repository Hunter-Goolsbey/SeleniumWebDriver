package Section07;



public class L21a_ThreadExtend extends Thread {
	
	public static void main(String[] args) {
		L21a_ThreadExtend thread = new L21a_ThreadExtend();
		thread.start();
		System.out.println("Outside of thread");
		
	}
	
	public void run() {
		System.out.println("Inside of thread");
	}
		
}