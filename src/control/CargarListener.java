package control;

import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;

import main.Juego;

public class CargarListener extends ClickListener<JButton>{

	public CargarListener(JButton target) {
		super(target);
	}

	public void mouseClicked(MouseEvent event, JButton target) {
		try {
			Juego.getInstance().cargar();
		}catch (FileNotFoundException e){
			e.printStackTrace();
			target.setText("No hay juego guardado");
			target.setEnabled(false);
		} catch (Exception e){
			e.printStackTrace();
			target.setText("Error");
			target.setEnabled(false);
		}
		target.repaint();
	}

}
