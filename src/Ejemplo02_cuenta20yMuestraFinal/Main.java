package Ejemplo02_cuenta20yMuestraFinal;

import java.util.concurrent.Semaphore;
/**
 * 
 * @author Ismael Mart�n
 *
 */
public class Main {

	public static void main(String[] args) {
		// Creacion del sem�foro
		Semaphore s = new Semaphore(0);

		// Iniciar Hilo final
		HiloFinal hf = new HiloFinal("\tHola soy el hilo final", s);
		hf.start();

		// Iniciar hilos
		for (int i = 0; i < 30; i++) {
			HiloCuenta h = new HiloCuenta("Hilo " + i, s,i);
			h.start();
		}

	}

}
