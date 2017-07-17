package modelo.nivel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.bloque.Bloque;
import modelo.bloque.BloqueAgujeroNegro;
import modelo.bloque.BloqueFuego;
import modelo.bloque.BloqueHielo;
import modelo.bloque.BloqueNaveEntrada;
import modelo.bloque.BloqueNaveSalida;
import modelo.bloque.BloqueRoca;
import modelo.bloque.BloqueTierra;

public class CargadorNivel {
	
	private static Pattern pattern = Pattern.compile("([^:=]+)[:=]{1}(.*)");
	
	public static Map<String, String> getPropiedades(String archivo) throws IOException{
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		InputStream in = CargadorNivel.class.getClassLoader().getResourceAsStream(archivo);

		BufferedReader reader = new BufferedReader(in != null ? new InputStreamReader(in) : new FileReader(archivo));
		
		String line = reader.readLine();
		
		while (line != null) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.matches()){
				map.put(matcher.group(1), matcher.group(2));
			} else {
				break;
			}
			line = reader.readLine();
		}
		reader.close();
		
		return map;
	}
	

	public static Bloque[][] cargaMatriz(String archivo, Nivel nivel) throws IOException{
		
		InputStream in = CargadorNivel.class.getClassLoader().getResourceAsStream(archivo);

		BufferedReader reader = new BufferedReader(in != null ? new InputStreamReader(in) : new FileReader(archivo));
		
		String line = reader.readLine();
		
		while (line != null && ! line.isEmpty()) {
			line = reader.readLine();
		}
		
		if (line == null) throw new IllegalStateException("Invalid level format");
		
		List<String> lines = new ArrayList<String>();
		line = reader.readLine();
		while (line != null) {
			lines.add(line);
			line = reader.readLine();
		}
		reader.close();
		
		Integer alto = lines.size();
		Integer ancho = lines.get(0).length();
		
		nivel.getPropiedades().setBloquesX(ancho);
		nivel.getPropiedades().setBloquesY(alto);
		
		Bloque[][] matriz = new Bloque[ancho][alto];
		
		Integer i=0,j=0;
		
		for (j = 0; j< alto; j++){
			for (i = 0; i < ancho; i++){
				Character caracter = lines.get(j).charAt(i);
				switch(caracter){
					case 'A' : matriz[i][j] = new BloqueAgujeroNegro().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'F' : matriz[i][j] = new BloqueFuego().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'H' : matriz[i][j] = new BloqueHielo().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'E' : matriz[i][j] = new BloqueNaveEntrada().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'R' : matriz[i][j] = new BloqueRoca().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'T' : matriz[i][j] = new BloqueTierra().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'S' : matriz[i][j] = new BloqueNaveSalida().setCoordenadas(i,j).setNivel(nivel);
								break;
					case 'V' : matriz[i][j] = null;
								break;
				}
			}
		}
		
		return matriz;
	}

}
