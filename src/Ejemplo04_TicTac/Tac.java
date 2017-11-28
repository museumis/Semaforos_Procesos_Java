package Ejemplo04_TicTac;

import java.util.concurrent.Semaphore;

public class Tac implements Runnable {

	Semaphore semaforoTic;
	Semaphore semaforoTac;
	String sonido;

	public Tac(Semaphore sTic, Semaphore sTac) {
		this.semaforoTic = sTic;
		this.semaforoTac = sTac;
		sonido = "tac";
	}

	@Override
	public void run() {	
		while(true) {
			try {
			semaforoTac.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println(sonido);
			semaforoTic.release();
			

		}
	}

}
