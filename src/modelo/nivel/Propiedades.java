package modelo.nivel;
import java.io.Serializable;
import java.util.Map;

import modelo.pooglin.habilidad.Habilidad;
import modelo.utils.Utils;


public class Propiedades implements Serializable {
	private static final long serialVersionUID = 5010014839537380545L;
	
	private Map<String, String> propiedades;
	
	public Propiedades(Map<String, String> propiedades) {
		this.propiedades = propiedades;
	}
	
	private Integer getInt(String key){
		String value = propiedades.get(key);
		return value != null ? Integer.parseInt(value) : null;
	}
	
	public Integer getTiempoLimite(){
		return Utils.OR(getInt("tiempoLimite"), Constantes.TIEMPO_LIMITE);
	}
	
	public Integer getPooglinsASalvar(){
		return Utils.OR(getInt("pooglinsASalvar"), Constantes.POOGLINS_A_SALVAR);
	}
	
	public Integer getPooglinsTotalNivel(){
		return Utils.OR(getInt("pooglinsTotalNivel"), Constantes.POOGLINS_TOTAL_NIVEL);
	}
	
	public Integer getBloquesX(){
		return getInt("bloquesX");
	}
	
	public Integer getBloquesY(){
		return getInt("bloquesY");
	}
	
	void setBloquesX(Integer x){
		propiedades.put("bloquesX", x.toString());
	}
	
	void setBloquesY(Integer y){
		propiedades.put("bloquesY", y.toString());
	}
	
	public Integer getTamanioX(){
		return getInt("bloquesX") * getAnchoBloque();
	}
	
	public Integer getTamanioY(){
		return getInt("bloquesY") * getAltoBloque();
	}
	
	public Integer getAltoPooglin(){
		return Utils.OR(getInt("pooglinAlto"), Constantes.POOGLIN_ALTO);
	}
	
	public Integer getAnchoPooglin(){
		return Utils.OR(getInt("pooglinAncho"), Constantes.POOGLIN_ANCHO);
	}
	
	public Integer getAltoBloque(){
		return Utils.OR(getInt("bloqueAlto"), Constantes.BLOQUE_ALTO);
	}
	
	public Integer getAnchoBloque(){
		return Utils.OR(getInt("bloqueAncho"), Constantes.BLOQUE_ANCHO);
	}
	
	public Integer getCantidadDisponibles(Class<? extends Habilidad> tipo){
		return Utils.OR(getInt(tipo.getSimpleName()), 0);
	}
	
	void restarDisponibles(Class<? extends Habilidad> tipo){
		propiedades.put(tipo.getSimpleName(), String.valueOf(
				Math.max(getCantidadDisponibles(tipo), 0) - 1));	
	}

}
