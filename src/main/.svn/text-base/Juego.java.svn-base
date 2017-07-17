package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import modelo.nivel.Constantes;
import modelo.nivel.Nivel;
import modelo.pooglin.habilidad.Habilidad;
import vista.VistaFrame;
import vista.VistaNivel;

public class Juego extends Thread {
	
	public static void main(String[] args){
		niveles = Arrays.asList("Nivel.txt", "Nivel2.txt","Nivel3.txt", "Nivel4.txt", "Nivel5.txt", "Nivel6.txt" );
		Habilidad.init();
		instance = new Juego();
	}
	
	private static List<String> niveles;
	private static Juego instance;
	
	public static Juego getInstance(){
		return instance;
	}
		
	private Nivel nivel;
	private Iterator<String> nivelIt;
	private boolean pausado = false;
	private boolean iniciado = false;

	private Juego(){
		nivelIt = niveles.iterator();
		VistaFrame.getInstance();
	}
	
	public void run(){
		do {
			iniciado = true;
			cicloNiveles();
		} while (nivel != null);
		iniciado = false;
	}
	
	
	private void cargarSiguiente(){
		nivel = nivelIt.hasNext() ? new Nivel(nivelIt.next()) : null;
		if (nivel != null)
			new VistaNivel(nivel);
	}
	
	protected void cicloNiveles(){
		if (nivel == null) return;
				
		while(! nivel.getGano() && ! nivel.getPerdio()){
 			Long time = Constantes.DELAY;
			if (! isPausado()) 
				time = nivel.ciclo();
			try { 
				Thread.sleep(time);
			} catch (InterruptedException e) { }
		}
		if (nivel.getGano()) {
			nivel.destruir();
			cargarSiguiente();
		}
	}
	
	public void guardarYSalir() throws Exception {
		setPausado(true);
		FileOutputStream save = new FileOutputStream("save.bin");
		ObjectOutputStream writer = new ObjectOutputStream(save);
		writer.writeObject(nivel);
		writer.close();
		VistaFrame.getInstance().dispose();
		System.exit(0);
	}
	
	public void cargar() throws Exception {
		FileInputStream save = new FileInputStream("save.bin");
		ObjectInputStream reader = new ObjectInputStream(save);
		Nivel nivelGuardado = (Nivel) reader.readObject();
		if (nivel != null) nivel.destruir();
		nivel = nivelGuardado;
		nivel.init();
		reader.close();		
		new VistaNivel(nivel);
		if (!isAlive()) start();
	}
	
	public void empezar(){
		cargarSiguiente();
		start();
	}


	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	public boolean isIniciado() {
		return iniciado;
	}
	
	public String getTiempo(){
		return nivel != null ? String.valueOf(nivel.getTiempo()) : "";
	}
	
	public String getPerdio(){
		return nivel != null && nivel.getPerdio() ? "Game over" : "";
	}
	
}

