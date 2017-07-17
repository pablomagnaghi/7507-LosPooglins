package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Juego;
import modelo.Elemento;
import modelo.nivel.Nivel;
import modelo.pooglin.habilidad.Habilidad;
import control.NivelMouseListener;

@SuppressWarnings("serial")
public class VistaNivel extends JPanel implements NivelObserver {
	
	private Map<Elemento, ElementoVisual> mapaModeloVista;
	
	private JPanel controls;
    
    public VistaNivel(Nivel nivel){
    	
        int ancho = nivel.getPropiedades().getTamanioX();
        int alto = nivel.getPropiedades().getTamanioY();
        
        setLayout(null);
        setVisible(true);
        setOpaque(true);
        setBackground(new Color(0, 0, 0));
        setOpaque(true);
        
        setSize(ancho, alto);
        setPreferredSize(new Dimension(ancho, alto));
       
        mapaModeloVista = new HashMap<Elemento, ElementoVisual>();

        nivel.registrarVista(this);
        
        controls = agregarControles(nivel, ancho);
                
        addMouseMotionListener(new NivelMouseListener());
        
        VistaFrame.getInstance().setVistaPanel(this, controls);
    }
    
    private JPanel agregarControles(final Nivel nivel, Integer ancho){
    	List<Class<? extends Habilidad>> clases = Habilidad.getHabilidades();
    	JPanel panel = new JPanel();
    	
    	panel.setLayout(new GridLayout(2, 6));
    	
    	for (Class<? extends Habilidad> clase : clases){
     		panel.add(new BotonHabilidad(nivel, clase));
    	}
    	
    	JLabel activos = new JLabel(){
    		public String getText() {
    			return "Activos: " + String.valueOf(nivel.getActivos());
    		}
    	};
    	
    	JLabel salvados = new JLabel(){
    		public String getText() {
    			return "Salvados: " + String.valueOf(nivel.getSalvados());
    		}
    	};
    	
    	JLabel muertos = new JLabel(){
    		public String getText() {
    			return "Muertos: " + String.valueOf(nivel.getMuertos());
    		}
    	};
    	
    	JLabel perdio = new JLabel(){
    		public String getText() {
    			return Juego.getInstance().getPerdio();
    		}
    	};
    	
     	JLabel tiempo = new JLabel(){
    		public String getText() {
    			return Juego.getInstance().getTiempo();
    		}
    	};
    	    	
    	panel.add(activos);
    	panel.add(salvados);
    	panel.add(muertos);
    	panel.add(perdio);
    	panel.add(tiempo);
    	
    	return panel;
    }

    private ElementoVisual getElementoVisual(Elemento elemento) {
        return mapaModeloVista.get(elemento);
    }

    private void remover(List<Elemento> objects) {
        Iterator<Elemento> it = objects.iterator();
        while (it.hasNext()) {
            Elemento elemento = it.next();
            ElementoVisual visual = getElementoVisual(elemento);
            mapaModeloVista.remove(elemento);
            remove(visual);
        }
    }

    private void crear(List<Elemento> objects) {
        Iterator<Elemento> it = objects.iterator();
        while (it.hasNext()) {
            Elemento elemento = it.next();
            if (elemento == null) continue;
            ElementoVisual visual = new ElementoVisual(elemento);
            mapaModeloVista.put(elemento, visual);
            add(visual, 0);
        }
    }

    private void actulizar(List<Elemento> objects) {
        Iterator<Elemento> it = objects.iterator();
        while (it.hasNext()) {
            Elemento elemento = it.next();
            ElementoVisual visual = getElementoVisual(elemento);
            if (visual != null) visual.update();
        }
    }
 
    public void update(List<Elemento> remover, List<Elemento> crear, List<Elemento> actualizar) {
        crear(crear);
    	remover(remover);
        actulizar(actualizar);
        controls.repaint();
        repaint();
    }

	public void init(List<Elemento> elementos) {
		crear(elementos);
		VistaFrame.getInstance().repaint();
	}

	public void destruir() {
		this.setVisible(false);
		controls.setVisible(false);
	}
}