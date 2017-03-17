package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import it.unisalento.pps.progettoEsame.business.VerbalizzazioneBusiness;
import it.unisalento.pps.progettoEsame.model.Esame;

public class Ascoltatore implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		
		String matricola="11223";
		int voto = 28;
		String codCorso = "123";
		
		Esame esame = VerbalizzazioneBusiness.getInstance().verbalizza(matricola, codCorso, voto);
		
		if(esame == null) {
			System.out.println("Qualcosa e' andato storto..");
			JOptionPane.showMessageDialog(null, "Qualcosa e' andato storto..");
		}
		else {
			System.out.println("Tutto ok!");
			JOptionPane.showMessageDialog(null, "Esame salvato!");
		}
		
	}

}
