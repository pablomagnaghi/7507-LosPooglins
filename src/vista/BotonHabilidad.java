package vista;

import javax.swing.JButton;

import control.SelectorHabilidad;

import modelo.nivel.Nivel;
import modelo.pooglin.habilidad.Habilidad;

public class BotonHabilidad extends JButton {
	private static final long serialVersionUID = 3107055674104985110L;
	
	
	private Nivel nivel;
	private Class<? extends Habilidad> clase;
	
	public BotonHabilidad(Nivel nivel, Class<? extends Habilidad> clase){
		super();
		
		this.nivel = nivel;
		this.clase = clase;
		
		addMouseListener(new SelectorHabilidad(clase));
	}
	
	public String getText() {
		return nivel != null ? clase.getSimpleName() + " (" + nivel.getPropiedades().getCantidadDisponibles(clase) +")" : "";
	}
	public boolean isEnabled() {
		return nivel != null ? nivel.getPropiedades().getCantidadDisponibles(clase) > 0 : false;
	}

}
