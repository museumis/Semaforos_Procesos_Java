package Ejemplo02_cuenta20yMuestraFinal;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Ismael Martin
 *
 */
public class HiloCuenta extends Thread {
	//Variables de la clase
	Semaphore s;
	String texto;
	int id;

	//Constructor de la clase
	public HiloCuenta(String texto, Semaphore s,int id) {
		this.texto = texto;
		this.s = s;
		this.id = id;
	}
	//Run
	@Override
	public void run() {
		
		System.out.println(texto);
		s.release(1);		
		

	}
}
