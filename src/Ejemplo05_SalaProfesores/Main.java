package Ejemplo05_SalaProfesores;

import java.util.concurrent.Semaphore;

public class Main {

	public static int NUM_PROFESORES = 0;
	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);
		Profesor[]profesores =  new Profesor[7];
		String nombres[]= {"Monte","Jadeo","Olivo","Demesio","Barrizo","Naranjo","Barranco"};
		
		for (int i = 0; i < profesores.length; i++) {
			profesores[i] = new Profesor(nombres[i],s);
			new Thread(profesores[i]).start();
		}
	}

}
