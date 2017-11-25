package Ejemplo03_anteriorOrdenado;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Ismael Martin
 *
 */
public class HiloFinal extends Thread {
	// Variables
	Semaphore s;
	String texto;

	// Constructor
	public HiloFinal(String texto, Semaphore s) {
		this.texto = texto;
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// Cuando el semáforo tenga 30 permisos despertará el hilo
			s.acquire(30);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Mostrar cuando despierte el hilo
		System.out.println(texto);
	}
}
