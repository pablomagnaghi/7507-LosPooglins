package modelo.pooglin;
import modelo.Elemento;
import modelo.nivel.Nivel;
import modelo.pooglin.habilidad.Caminar;
import modelo.pooglin.habilidad.Habilidad;
import modelo.pooglin.habilidad.PlatilloVolador;
import modelo.utils.Posicion;
import modelo.utils.Sentido;

public class Pooglin implements Elemento {
	
	private static final long serialVersionUID = -3838342570913637157L;

	private Habilidad habilidad;
	
	private Posicion posicion;
	
	private Sentido sentido;
	
	protected Integer contadorCaida = null;
	
	private Nivel nivel;
	
	private boolean activo;
	
	protected Integer factorVelocidad = 1;	
	
	public Pooglin (Nivel nivel){
		this.sentido = Sentido.DERECHA;
		this.habilidad = new Caminar(this);
		this.nivel = nivel;
		this.activo = true;
	}
	
	public Pooglin (Posicion posicion, Nivel nivel){
		this(nivel);
		this.posicion = posicion;
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}

	public Pooglin setHabilidad(Habilidad habilidad) {
		if (!this.isCayendo()){
		this.habilidad = habilidad;
		}else{
			if ((habilidad.getClass()==PlatilloVolador.class) || (habilidad.getClass()==Caminar.class)){
				this.habilidad = habilidad;
			}
		}
		return this;
	}
	
	public Sentido getSentido() {
		return sentido;
	}
	
	public Pooglin setSentido(Sentido sentido) {
		this.sentido = sentido;
		return this;
	}
	
	public Pooglin rebotar(){
		habilidad.rebotar();
		return this;
	}
	
	public Pooglin setCayendo(){
		habilidad.setCayendo();
		return this;
	}
	
	public Pooglin detenerCaida(){
		if (this.isCayendo()){
		habilidad.detenerCaida();
		}
		return this;
	}
	
	public boolean isActivo() {
		return activo;
	}

	Pooglin setActivo(boolean activo) {
		this.activo = activo;
		return this;
	}
	
	public Pooglin morir(){
		setActivo(false);
		nivel.muere(this);
		return this;
	}
	
	public Pooglin salvar(){
		setActivo(false);
		nivel.salvado(this);
		return this;
	}

	public Integer getContadorCaida() {
		return contadorCaida;
	}

	public void setContadorCaida(Integer contadorCaida) {
		this.contadorCaida = contadorCaida;
	}

	public Integer getFactorVelocidad() {
		return factorVelocidad;
	}

	public Pooglin resetVelocidad(){
		factorVelocidad = 1;
		return this;
	}
	
	public Pooglin duplicarVelocidad(){
		factorVelocidad = 2;
		return this;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Nivel getNivel() {
		return nivel;
	}

	@Override
	public String getNombre() {
		return habilidad.getNombre();
	}

	@Override
	public Integer getAlto() {
		return nivel.getPropiedades().getAltoPooglin();
	}

	@Override
	public Integer getAncho() {
		return nivel.getPropiedades().getAnchoPooglin();
	}
	
	public boolean isCayendo(){
		return contadorCaida != null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (! (obj instanceof Pooglin))
			return false;
		Pooglin that = (Pooglin) obj;
		Boolean equals = this.getPosicion().equals(that.getPosicion());
		equals &= this.getHabilidad().getClass().equals(that.getHabilidad().getClass());
		equals &= this.isActivo() == that.isActivo();
		equals &= this.getSentido().equals(that.getSentido());
		
		return equals;
	}

}
	    
