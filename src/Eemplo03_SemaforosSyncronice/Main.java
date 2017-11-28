package Eemplo03_SemaforosSyncronice;

import java.util.concurrent.Semaphore;

public class Main {

	static int GLOBOS = 1000;

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1);
		Semaphore join = new Semaphore(0);

		Amigo[]amigos = new Amigo[3];
		String nombres[]= {"Agapito","Evaristo","Oeustaquio"};
		
		for (int i = 0; i < amigos.length; i++) {
			amigos[i] = new Amigo(mutex, nombres[i],join);
			new Thread(amigos[i]).start();
			
		}
		
		try {
			join.acquire(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Todos los globos fueron explotados.");
		for (int i = 0; i < amigos.length; i++) {
			System.out.println(amigos[i].toString()+"weee");
		}
		
		
	}

}
