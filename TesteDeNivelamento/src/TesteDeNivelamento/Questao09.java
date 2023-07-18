package TesteDeNivelamento;

public class Questao09 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t01 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("tarefa_a");
			}
		});
		
		Thread t02 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("tarefa_b");
			}
		});
		
		Thread t03 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("tarefa_c");
			}
		});
		
		Thread t04 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("tarefa_fim");
			}
		});
		
		t01.start();
		Thread.sleep(getMillis());
		t02.start();
		Thread.sleep(getMillis());
		t03.start();
		Thread.sleep(getMillis());
		t04.start();
		
		try {
			t01.join();
			t02.join();
			t03.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static long getMillis() {
		return (long)(Math.random() * 6_500);
	}
}
