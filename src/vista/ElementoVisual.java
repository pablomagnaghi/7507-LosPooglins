package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Elemento;
import modelo.pooglin.Pooglin;
import modelo.utils.Posicion;
import control.PooglinListener;

public class ElementoVisual extends JLabel {
    private static final long serialVersionUID = -8049202541490623884L;

    protected Elemento elemento;

    public ElementoVisual(Elemento elemento) {
        super();
        this.elemento = elemento;
        if (elemento instanceof Pooglin) {
        	PooglinListener listener = new PooglinListener((Pooglin) elemento);
        	addMouseListener(listener);
        	addComponentListener(listener);
            addMouseMotionListener(listener);
        }
        update();
    }

    public void update() {
    	setSize(elemento.getAncho(), elemento.getAlto());
    	
		ImageIcon icon = CargadorImagenes.getInstance().
			getIconForName(elemento.getNombre(), elemento.getAncho(), elemento.getAlto());
        setIcon(icon);
    	
        Posicion posicion = elemento.getPosicion();
        setLocation(posicion.getX(), posicion.getY());
    }

    public Elemento getElemento() {
        return elemento;
    }

}
