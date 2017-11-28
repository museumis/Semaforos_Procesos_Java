package Eemplo03_SemaforosSyncronice;

import java.util.concurrent.Semaphore;

public class Amigo implements Runnable{

	Semaphore mutex;
	Semaphore join;
	String nombre;
	int explotados;

	public Amigo(Semaphore m, String n, Semaphore join) {
		mutex = m;
		this.nombre = n;
		explotados = 0;
		this.join = join;
	}

	@Override
	public void run() {
		while (explotar()) {
			Thread.yield();
		}
		join.release();
	}

	/**
	 * El hilo explota
	 * 
	 * @return
	 */
	public boolean explotar() {
		try {
			mutex.acquire();
			System.out.println(this.nombre + " cogió un globo");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Main.GLOBOS--;
		this.explotados++;
		System.out.println("\t" + this.nombre + " explotó un globo");

		if (Main.GLOBOS == 0) {
			return false;
		}

		System.out.println("\t\tQuedan " + Main.GLOBOS + " por explotar.");
		mutex.release();
		return true;
	}// Fin de explotar

	@Override
	public String toString() {
		return this.nombre + " explotó " + explotados;

	}
}
