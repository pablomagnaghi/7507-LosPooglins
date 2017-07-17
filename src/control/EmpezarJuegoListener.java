package control;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import main.Juego;

public class EmpezarJuegoListener extends ClickListener<JButton> {

	public EmpezarJuegoListener(JButton target) {
		super(target);
	}

	public void mouseClicked(MouseEvent event, JButton target) {
		if (Juego.getInstance().isIniciado()) {
			if (Juego.getInstance().isPausado()){
				Juego.getInstance().setPausado(false);
				target.setText("Pausar");
			} else {
				Juego.getInstance().setPausado(true);
				target.setText("Seguir");
			}
		} else {
			Juego.getInstance().empezar();
			target.setText("Pausar");
		}
		target.repaint();
	}
	
}
