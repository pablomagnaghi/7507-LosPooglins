package test;

import junit.framework.*;

import modelo.nivel.*;
import modelo.pooglin.Pooglin;
import modelo.pooglin.habilidad.*;
import modelo.utils.*;

public class PooglinTest extends TestCase {
	
	Pooglin pooglin;
	Nivel nivel;
	
	protected void setUp() throws Exception {
		nivel = new Nivel("Nivel.txt");
		pooglin = new Pooglin(nivel);
	}
	
	public void testPooglin (){
		// Prueba de set y get Posicion
		Posicion pos = new Posicion(2,2);
		pooglin.setPosicion(pos);
		Assert.assertEquals(2, pooglin.getPosicion().getX().intValue());
		Assert.assertEquals(2, pooglin.getPosicion().getY().intValue());
		
		// Prueba de Habilidades
		Assert.assertEquals(Caminar.class, pooglin.getHabilidad().getClass());
		pooglin.setHabilidad(new Teletransportacion(pooglin)); 
		Assert.assertEquals(Teletransportacion.class, pooglin.getHabilidad().getClass());
		
		
	}
}
