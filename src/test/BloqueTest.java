package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import modelo.bloque.Bloque;
import modelo.bloque.BloqueTierra;
import modelo.utils.Coordenadas;

public class BloqueTest extends TestCase {
	
	public void testBloque(){
		Bloque bloque = new BloqueTierra();
		bloque.setCoordenadas(8, 7);
		Assert.assertEquals(8, bloque.getCoordenadas().getI().intValue());
		Assert.assertEquals(7, bloque.getCoordenadas().getJ().intValue());
		Coordenadas coo = new Coordenadas(4,3);
		bloque.setCoordenadas(coo);
		Assert.assertEquals(4, bloque.getCoordenadas().getI().intValue());
		Assert.assertEquals(3, bloque.getCoordenadas().getJ().intValue());
		
	}

}
