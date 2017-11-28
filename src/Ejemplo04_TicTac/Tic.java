package Ejemplo04_TicTac;

import java.util.concurrent.Semaphore;

public class Tic implements Runnable {
	Semaphore semaforoTic;
	Semaphore semaforoTac;

	String sonido;

	public Tic(Semaphore sTic, Semaphore sTac) {
		this.semaforoTic = sTic;
		this.semaforoTac = sTac;
		sonido = "\ttic";
	}

	@Override
	public void run() {
		while(true) {
			try {
			semaforoTic.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println(sonido);

			semaforoTac.release();

		}
		
		
		
		
		
	}
}
