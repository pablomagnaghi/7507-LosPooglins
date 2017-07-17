package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import modelo.Elemento;
import modelo.bloque.BloqueNaveEntrada;
import modelo.bloque.BloquePooglinCongelado;
import modelo.nivel.Nivel;
import modelo.utils.Coordenadas;
import vista.NivelObserver;


public class NivelTest extends TestCase {
	
	Nivel nivel;
	
	protected void setUp() throws Exception {
		nivel = new Nivel("NivelPrueba.txt");
		}		
	
	public void testNivelPropiedades(){
		Assert.assertEquals(10, nivel.getPropiedades().getPooglinsASalvar().intValue());
		Assert.assertEquals(10, nivel.getPropiedades().getPooglinsTotalNivel().intValue());
		Assert.assertEquals(30, nivel.getPropiedades().getBloquesX().intValue());
		Assert.assertEquals(20, nivel.getPropiedades().getBloquesY().intValue());
		Assert.assertEquals(500, nivel.getPropiedades().getTiempoLimite().intValue());
		Assert.assertEquals(1200, nivel.getPropiedades().getTamanioX().intValue());
		Assert.assertEquals(800, nivel.getPropiedades().getTamanioY().intValue());
	}
	
	public void testNivelBloques(){
		//en el archivo terreno de prueba en la pos 2,4 esta el BloqueNaveEntrada
		Coordenadas coordenada=new Coordenadas(2,4);
		Assert.assertTrue(nivel.estaDentroDeLimites(coordenada));
		Assert.assertEquals(BloqueNaveEntrada.class , nivel.getBloque(coordenada).getClass());
		
		//Prueba del crearBloque
		BloquePooglinCongelado pooglinCongelado = new BloquePooglinCongelado();
		Coordenadas cooBNuevo = new Coordenadas(3,4);
		pooglinCongelado.setCoordenadas(cooBNuevo);
		nivel.crearBloque(pooglinCongelado);
		Assert.assertEquals(BloquePooglinCongelado.class , nivel.getBloque(cooBNuevo).getClass());

		//Prueba del destruirBloque, destruimos el bloque anterior
		nivel.destruirBloque(pooglinCongelado);
		Assert.assertNull(nivel.getBloque(cooBNuevo));
		
		//Prueba del estavacio
		Assert.assertTrue(nivel.estaVacia(new Coordenadas(2,2)));
		
		//Prueba esta dentro de limites
		Assert.assertFalse(nivel.estaDentroDeLimites(new Coordenadas(-1,3)));
		
		
		
	}
	
	
	public void testSerializacion() throws IOException, ClassNotFoundException{
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		fos = new FileOutputStream("nivel.save");
		out = new ObjectOutputStream(fos);
		out.writeObject(nivel);
		
		nivel.registrarVista(new NivelObserver(){
			public void init(List<Elemento> elementos) {
			}
			public void update(List<Elemento> remover, List<Elemento> crear,
					List<Elemento> actualizar) {
			}
			public void destruir() {
			}
		});
		
		out.close();

		FileInputStream fis = null;
		ObjectInputStream in = null;
		Nivel otroNivel = null; 
		fis = new FileInputStream("nivel.save");
		in = new ObjectInputStream(fis);
		otroNivel = (Nivel)in.readObject();
		in.close();
		
		assertNull(otroNivel.getObserver());
	}
	
	
	
}
