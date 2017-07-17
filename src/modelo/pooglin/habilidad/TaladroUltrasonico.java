package modelo.pooglin.habilidad;

import modelo.bloque.Bloque;
import modelo.nivel.Constantes;
import modelo.pooglin.Pooglin;

public class TaladroUltrasonico extends Habilidad{
	private static final long serialVersionUID = 681796708020795616L;
	
	private Integer bloques = 0;
	private Integer impactos = 0;
	private Integer caida;
	
	public TaladroUltrasonico(){
		super();
	}

	public TaladroUltrasonico(Pooglin pooglin) {
		super(pooglin);
	}

	// Con esta herramienta, un Pooglin puede 
	// excavar un pozo de 5 bloques de profundidad
	
	public Pooglin accion() {
		
		if (! pooglin.isCayendo()) {
			caida=0;			
			Bloque bloque = getNivel().getBloqueBajo(pooglin.getPosicion());
			if (bloque != null) {
				bloque.impacto();
				impactos++;
				if (bloque.isDestruido()){
					bloques++;
					pooglin.setCayendo();
				}
			}
		} else {
			desplazarVertical();
			caida++;
		}
		
		if (caida > (2*getPropiedades().getAltoBloque()/Constantes.POOGLIN_DEFAUT_VALOCIDAD_CAIDA - 5)){
			pooglin.setHabilidad(new Caminar(pooglin));
		}
		
		if (bloques == Constantes.TALADRO_DESTRUYE_BLOQUES || impactos == Constantes.TALADRO_IMPACTOS)
			pooglin.setHabilidad(new Caminar(pooglin));
		
		return pooglin;
	}
}
