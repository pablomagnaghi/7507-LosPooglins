package control;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modelo.pooglin.habilidad.Habilidad;

public class SelectorHabilidad extends ClickListener<Class<? extends Habilidad>>{
	
	private static Class<? extends Habilidad> habilidad;
	private static JButton boton;
	
	public static void seleccionar(Class<? extends Habilidad> habilidad, JButton boton){
		SelectorHabilidad.habilidad = habilidad;
		SelectorHabilidad.boton = boton;
	}
	
	public static Class<? extends Habilidad> getSeleccionada(){
		if (habilidad == null) return null;
		boton.setEnabled(boton.isEnabled());
		boton.setSelected(false);
		boton.repaint();
		Class<? extends Habilidad> rv = habilidad;
		habilidad = null;
		return rv;
	}
	
	public static boolean haySeleccionada(){
		return habilidad != null;
	}
	
	public SelectorHabilidad(Class<? extends Habilidad> target) {
		super(target);
	}

	public void mouseClicked(MouseEvent event, Class<? extends Habilidad> target) {
		JButton boton = (JButton) event.getComponent();
		if (! boton.isEnabled()) return;
		seleccionar(target, boton);
		boton.setSelected(true);
	}
	
	public static void reset() {
		SelectorHabilidad.habilidad = null;
		SelectorHabilidad.boton = null;
	}
}
