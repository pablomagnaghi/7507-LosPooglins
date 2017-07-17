package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class ClickListener<T> implements MouseListener {
	
	protected T target;
	
	public ClickListener(T target){
		this.target = target;
	}
	
	public abstract void mouseClicked(MouseEvent event, T target);
	
	
	public void mouseClicked(MouseEvent event) {
		mouseClicked(event, target);
	}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

}