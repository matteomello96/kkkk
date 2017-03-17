package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

public class InvioListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CARATTERE PREMUTO: "+e.getKeyChar());
		JTextArea textArea = (JTextArea)e.getSource();
		if(textArea.getText().length() > 10) {
			System.out.println("Limite superato!");
			textArea.setText(textArea.getText().substring(0, 11));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
