package Ejemplo03_anteriorOrdenado;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Ismael Martín
 *
 */
public class Main {

	public static void main(String[] args) {
		// Creacion del semáforo
		Semaphore[] semaforos = new Semaphore[31];
		HiloCuenta[] hilos = new HiloCuenta[30];

		// Iniciar semaforos
		for (int i = 0; i < semaforos.length; i++) {
			semaforos[i] = new Semaphore(0);
		}
			// Iniciar hilos
		for (int i = 0; i < 30; i++) {

			hilos[i] = new HiloCuenta("Hilo " + i, semaforos[i], semaforos[i + 1], i);
			hilos[i].start();
		}
		semaforos[0].release();
		try {
			semaforos[30].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Programa terminado");
	}

}
