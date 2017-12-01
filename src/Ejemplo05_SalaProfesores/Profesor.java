package Ejemplo05_SalaProfesores;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Ismael Martin
 *
 */
public class Profesor implements Runnable {

	Semaphore s;
	String nombre;

	public Profesor(String nombre, Semaphore sema) {
		this.nombre = nombre;
		this.s = sema;		
	}

	@Override
	public void run() {
		while(true) {
			Thread.yield();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				s.acquire();
				Main.NUM_PROFESORES++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t"+this.nombre + " entró en la sala. Hay "+ Main.NUM_PROFESORES + " profesores en la sala.");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.nombre + " se dispone a salir.");
			Main.NUM_PROFESORES--;
			s.release();

		}

	}

}
