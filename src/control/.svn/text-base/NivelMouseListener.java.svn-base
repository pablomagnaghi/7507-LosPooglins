package control;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import modelo.utils.Utils;

public class NivelMouseListener implements MouseMotionListener{
	
	private static Point lastPoint;

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		lastPoint = e.getPoint();
	}
	
	//Si un objeto se mueve bajo el mouse no se dispara el mouseover, asi que tengo necesito la
	//posicion del mouse para checkear que si el ocmponente esta bajo el cursor.
	static Point getLastPoint(){
		return Utils.OR(lastPoint, new Point(0 ,0));
	}

	
	
}
