package Ejemplo04_TicTac;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore tic = new Semaphore(1);
		Semaphore tac = new Semaphore(0);
		
		
		Tic hilo1 = new Tic(tic,tac);
		Tac hilo2 = new Tac(tic,tac);

		new Thread(hilo1).start();
		new Thread(hilo2).start();
	}

}
