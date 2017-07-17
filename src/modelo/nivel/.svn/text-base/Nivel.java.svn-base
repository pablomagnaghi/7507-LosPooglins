package modelo.nivel;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import control.SelectorHabilidad;

import modelo.Elemento;
import modelo.bloque.Bloque;
import modelo.bloque.BloqueNaveEntrada;
import modelo.bloque.BloqueTunelElectro;
import modelo.pooglin.Pooglin;
import modelo.pooglin.habilidad.Habilidad;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;
import modelo.utils.Utils;
import vista.NivelObserver;

public class Nivel implements Serializable {
	private static final long serialVersionUID = -8344032869106262592L;

	private Bloque[][] terreno;
	
	private List<Pooglin> pooglins;
		
	private Integer salvados = 0;
	
	private Integer muertos = 0;

	private Propiedades propiedades;
	
	transient private NivelObserver observer;
	
	private boolean gano = false;
	
	private boolean perdio = false;
	
	private Long tiempo;
	
	private transient List<Elemento> nuevos;
	
	private transient List<Elemento> modificados;
	
	private transient List<Elemento> removidos;

	public Nivel(String archNivel) {
	
		try{
			propiedades = new Propiedades(CargadorNivel.getPropiedades(archNivel));
			pooglins = new LinkedList<Pooglin>();
			terreno = CargadorNivel.cargaMatriz(archNivel, this);	
			
			tiempo = propiedades.getTiempoLimite() * 1000L;
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
		init();
	}
	
	public void init(){
		nuevos = new LinkedList<Elemento>();
		modificados = new LinkedList<Elemento>();
		removidos = new LinkedList<Elemento>();
	}
		
	public Propiedades getPropiedades() {
		return propiedades;
	}
	
	public boolean estaVacia(Coordenadas coordenadas){
		return getBloque(coordenadas) == null || getBloque(coordenadas) instanceof BloqueTunelElectro;
	}
	
	public Coordenadas aCoordenadas(Posicion posicion){
		Integer x = posicion.getX();
		Integer y = posicion.getY();
		
		x = x >= 0 ? x : -1 * propiedades.getAnchoBloque();
		y = y >= 0 ? y : -1 * propiedades.getAltoBloque();
		
		return new Coordenadas(x / propiedades.getAnchoBloque(), y / propiedades.getAltoBloque());
	}
	
	public Posicion aPosicion(Coordenadas coordenadas){
		return new Posicion(coordenadas.getI() * propiedades.getAnchoBloque(), 
				coordenadas.getJ() * propiedades.getAltoBloque());
	}
	
	public Bloque getBloque(Posicion posicion){
		return getBloque(aCoordenadas(posicion));
	}
	
	public Bloque getBloque(Coordenadas coordenadas){
		return terreno[coordenadas.getI()][coordenadas.getJ()];
	}
	
	public Bloque getBloqueBajo(Posicion pos){
		Posicion pos1 = pos.clonar();
		
		pos1.setY(pos1.getY() + 1 + propiedades.getAltoPooglin());
		
		Posicion pos2 = pos1.clonar();
		
		pos2.setX(pos2.getX() + propiedades.getAnchoPooglin());
		
		Bloque bloque1 = estaDentroDeLimites(aCoordenadas(pos1)) ? getBloque(pos1) : null;
		
		Bloque bloque2 = estaDentroDeLimites(aCoordenadas(pos2)) ? getBloque(pos2) : null;
		
		if (bloque1 != null && bloque2 != null && bloque1 != bloque2){
			
			Integer superposicion1 = bloque1.getAncho() - pos1.getX() % bloque1.getAncho();
			
			Integer superposicion2 = pos2.getX() % bloque2.getAncho();
			
			if (superposicion1 > superposicion2) return bloque1;
			
			if (superposicion2 > superposicion1) return bloque2;
		}
		
		return Utils.OR(bloque1, bloque2);
	}
	
	
	
	public synchronized void crearBloque(Bloque nuevo){
		nuevo.setNivel(this);
		terreno[nuevo.getCoordenadas().getI()][nuevo.getCoordenadas().getJ()] = nuevo;
		nuevos.add(nuevo);
	}
	
	public synchronized void destruirBloque(Bloque bloque){
		terreno[bloque.getCoordenadas().getI()][bloque.getCoordenadas().getJ()] = null;
		bloque.setDestruido();
		removidos.add(bloque);
	}
	
	public synchronized void muere(Pooglin pooglin){
		removidos.add(pooglin);
		muertos++;
	}
	
	public synchronized void salvado(Pooglin pooglin){
		removidos.add(pooglin);
		salvados++;
	}
	
	public synchronized void agregar(Pooglin pooglin){
		pooglins.add(pooglin);
		nuevos.add(pooglin);
	}
	
	public synchronized Habilidad newHabilidad(Pooglin pooglin, Class<? extends Habilidad> tipo){
		Habilidad habilidad;
		try {
			habilidad = tipo.newInstance();
			propiedades.restarDisponibles(tipo);
			habilidad.setPooglin(pooglin);
			return habilidad;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized Long ciclo(){
		Long espera = System.currentTimeMillis();
		
		ListIterator<Pooglin> pooglinIterator = pooglins.listIterator();
		
		while((pooglinIterator.hasNext()) && (!pooglins.isEmpty())){
			
			Pooglin pooglin = pooglinIterator.next();

			//Debajo
			Bloque bloque = getBloqueBajo(pooglin.getPosicion());
			
			if (bloque != null)
				bloque.bajoPooglin(pooglin);
			else {
				Posicion pos = pooglin.getPosicion().clonar();
				pos.setY(pos.getY() + 1 + pooglin.getAlto());
				if (estaDentroDeLimites(aCoordenadas(pos)))				
					pooglin.setCayendo();
				else
					pooglin.detenerCaida();
			}
			
			Posicion posicion = pooglin.getPosicion().clonar();
				
			//Lateral
			
			posicion.setX(posicion.getX() + Math.max(0, pooglin.getSentido().factor * pooglin.getAncho()));
			
			bloque = getBloque(posicion);
			if (bloque != null && pooglin.isActivo())
				bloque.lateralAPooglin(pooglin);
	
			if (pooglin.isActivo()) {
				modificados.add(pooglin.getHabilidad().accion());
			} else {
				pooglinIterator.remove();
			}
		}

		observer.update(removidos, nuevos, modificados);
		
		nuevos.clear();
		modificados.clear();
		removidos.clear();
		
		if (salvados >= propiedades.getPooglinsASalvar()) 
			gano = true;
		if (muertos > propiedades.getPooglinsTotalNivel() - propiedades.getPooglinsASalvar() || tiempo <= 0)
			perdio = true;
		
		espera = System.currentTimeMillis() - espera + Constantes.DELAY;
		tiempo -= espera;
		
		return espera;
	}
	
	public boolean getGano() {
		return gano;
	}

	public boolean getPerdio() {
		return perdio;
	}

	public boolean estaDentroDeLimites(Coordenadas coordenadas){
		try {
			getBloque(coordenadas);
			return true;
		} catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
	}

	public List<Pooglin> getListaPooglin(){
		return this.pooglins;
	}
	
	public synchronized void registrarVista(NivelObserver vista) {
		
		nuevos.addAll(pooglins);
		for (int i = 0; i < terreno.length; i++){
			for (int j = 0; j < terreno[i].length; j++)
				nuevos.add(terreno[i][j]);
		}
		this.observer = vista;
		vista.init(nuevos);
		
		nuevos.clear();
	}
	
	public NivelObserver getObserver() {
		return observer;
	}
	
	public void destruir(){
		BloqueNaveEntrada.reset();
		terreno = null;
		observer.destruir();
		SelectorHabilidad.reset();
	}
	
	public Integer getActivos() {
		return pooglins.size();
	}

	public Integer getSalvados() {
		return salvados;
	}

	public Integer getMuertos() {
		return muertos;
	}
	
	public Long getTiempo() {
		return tiempo / 1000;
	}
}


