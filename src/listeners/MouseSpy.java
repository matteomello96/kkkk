package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseSpy implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Evento verificatosi alle coordinate "+e.getX()+" "+e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
