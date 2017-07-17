package modelo.bloque;

import modelo.pooglin.Pooglin;

public class BloqueNaveSalida extends Bloque{
	
	private static final long serialVersionUID = 4397664010833445385L;

	public void bajoPooglin(Pooglin pooglin) {
		super.bajoPooglin(pooglin);
		pooglin.salvar();
	}
	
	public void lateralAPooglin(Pooglin pooglin) {
		pooglin.salvar();
	}
	
}
