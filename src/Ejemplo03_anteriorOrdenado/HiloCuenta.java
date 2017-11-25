package Ejemplo03_anteriorOrdenado;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Ismael Martin
 *
 */
public class HiloCuenta extends Thread {
	//Variables de la clase
	Semaphore sAnterior;
	Semaphore sPosterior;
	String texto;
	int id;

	//Constructor de la clase
	public HiloCuenta(String texto, Semaphore sAnterior, Semaphore sPosterior,int id) {
		this.texto = texto;
		this.sAnterior = sAnterior;
		this.sPosterior = sPosterior;
		this.id = id;
	}
	//Run
	@Override
	public void run() {
		
		
		try {
			sAnterior.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(texto);
		
		sPosterior.release();


	}
}
