package control;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import modelo.pooglin.Pooglin;
import modelo.pooglin.habilidad.Habilidad;
import vista.ElementoVisual;

public class PooglinListener extends ClickListener<Pooglin> implements ComponentListener, MouseMotionListener {
	
	private static final Border BORDE = new LineBorder(Color.WHITE, 2);
	private static final Border BORDE_SELECCIONADA = new LineBorder(Color.GREEN, 2);

	public PooglinListener(Pooglin target) {
		super(target);
	}

	public void mouseClicked(MouseEvent event, Pooglin pooglin) {
		Class<? extends Habilidad> tipo = SelectorHabilidad.getSeleccionada();
		if (tipo == null) return;
		
		pooglin.getNivel().newHabilidad(pooglin, tipo);
	}
	
	public void mouseEntered(MouseEvent event) {
		ElementoVisual elemento = (ElementoVisual) event.getComponent();
		ponerBorde(elemento);
	}

	public void mouseExited(MouseEvent event) {
		ElementoVisual elemento = (ElementoVisual) event.getComponent();
		sacarBorde(elemento);
	}
	
	public void componentMoved(ComponentEvent event) {
		Point point = NivelMouseListener.getLastPoint();
		ElementoVisual elemento = (ElementoVisual) event.getComponent();
		checkMouseOver(point, elemento);
	}

	private void checkMouseOver(Point point, ElementoVisual elemento) {
		
		Double x = point.getX() - target.getPosicion().getX();
		Double y = point.getY() - target.getPosicion().getY();
		
		if (x >= 0 && y >= 0 && x < target.getAncho() && y < target.getAlto())
			ponerBorde(elemento);
		else
			sacarBorde(elemento);
	}

	public void mouseMoved(MouseEvent event) {
		ElementoVisual elemento = (ElementoVisual) event.getComponent();
		Point point = new Point(event.getX() + target.getPosicion().getX(), 
				event.getY() + target.getPosicion().getY());
		
		checkMouseOver(point, elemento);
	}
	
	private void ponerBorde(ElementoVisual elemento){
		elemento.setBorder(SelectorHabilidad.haySeleccionada() ? BORDE_SELECCIONADA : BORDE);
	}
	
	private void sacarBorde(ElementoVisual elemento){
		elemento.setBorder(null);
	}
	
	public void componentHidden(ComponentEvent event) {}

	public void componentResized(ComponentEvent event) {}

	public void componentShown(ComponentEvent event) {}

	public void mouseDragged(MouseEvent e) {}

}
