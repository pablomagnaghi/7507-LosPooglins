package control;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import main.Juego;

public class SalirListener extends ClickListener<JButton>{

	public SalirListener(JButton target) {
		super(target);
	}

	public void mouseClicked(MouseEvent event, JButton target) {
		try {
			Juego.getInstance().guardarYSalir();
		} catch (Exception e) {
			e.printStackTrace();
			target.setText("Error");
			target.setEnabled(false);
			target.repaint();
		}
	}

}
