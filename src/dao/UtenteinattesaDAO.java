package dao;

import java.util.ArrayList;

import connessioneDB.DbConnection;
import modelli.Utenteinattesa;
import modelli.Tesserato;
import modelli.Tipoutente;
import modelli.Utentegenerico;

	public class UtenteinattesaDAO {

		private static UtenteinattesaDAO instance;
		
		public static synchronized UtenteinattesaDAO getInstance() {
			if(instance == null)
				instance = new UtenteinattesaDAO();
			return instance;
		}

		public Utenteinattesa CercaperCodice(int codiceregistrazione) {
			
		  Utenteinattesa uatt = new Utenteinattesa();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE codiceregistrazione='"+codiceregistrazione+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
			Utentegenerico utentegenerico = new Utentegenerico();
			utentegenerico.setNome(riga[1]);
			utentegenerico.setCognome(riga[2]);
			utentegenerico.setCodicefiscale(riga[3]);
			utentegenerico.setVia(riga[4]);
			utentegenerico.setCittaresidenza(riga[5]);
			utentegenerico.setUsername(riga[6]);
			utentegenerico.setPass(riga[7]);
			utentegenerico.setNumerotelefono(riga[8]);
			utentegenerico.setIndirizzomail(riga[9]);
			Tipoutente.TrovaperTipoutente(riga[10]);
			return uatt;
			
		}
		
		public Utenteinattesa CercaperNome(String nome) {
			
			Utenteinattesa uatt = new Utenteinattesa();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE nome='"+nome+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
			Utentegenerico utentegenerico = new Utentegenerico();
			utentegenerico.setNome(riga[1]);
			utentegenerico.setCognome(riga[2]);
			utentegenerico.setCodicefiscale(riga[3]);
			utentegenerico.setVia(riga[4]);
			utentegenerico.setCittaresidenza(riga[5]);
			utentegenerico.setUsername(riga[6]);
			utentegenerico.setPass(riga[7]);
			utentegenerico.setNumerotelefono(riga[8]);
			utentegenerico.setIndirizzomail(riga[9]);
			Tipoutente.TrovaperTipoutente(riga[10]);
			return uatt;
		}



public Utenteinattesa CercaperCognome(String cognome) {
	
	Utenteinattesa uatt = new Utenteinattesa();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE cognome='"+cognome+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
	Utentegenerico utentegenerico = new Utentegenerico();
	utentegenerico.setNome(riga[1]);
	utentegenerico.setCognome(riga[2]);
	utentegenerico.setCodicefiscale(riga[3]);
	utentegenerico.setVia(riga[4]);
	utentegenerico.setCittaresidenza(riga[5]);
	utentegenerico.setUsername(riga[6]);
	utentegenerico.setPass(riga[7]);
	utentegenerico.setNumerotelefono(riga[8]);
	utentegenerico.setIndirizzomail(riga[9]);
	Tipoutente.TrovaperTipoutente(riga[10]);
	return uatt;
}

public Utenteinattesa CercaperVia(String via) {
	
	Utenteinattesa uatt = new Utenteinattesa();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE via='"+via+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
	Utentegenerico utentegenerico = new Utentegenerico();
	utentegenerico.setNome(riga[1]);
	utentegenerico.setCognome(riga[2]);
	utentegenerico.setCodicefiscale(riga[3]);
	utentegenerico.setVia(riga[4]);
	utentegenerico.setCittaresidenza(riga[5]);
	utentegenerico.setUsername(riga[6]);
	utentegenerico.setPass(riga[7]);
	utentegenerico.setNumerotelefono(riga[8]);
	utentegenerico.setIndirizzomail(riga[9]);
	Tipoutente.TrovaperTipoutente(riga[10]);
	return uatt;
}
public Utenteinattesa CercaperNumerocivico(String numerocivico) {
	
	Utenteinattesa uatt = new Utenteinattesa();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE numerocivico='"+numerocivico+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
	Utentegenerico utentegenerico = new Utentegenerico();
	utentegenerico.setNome(riga[1]);
	utentegenerico.setCognome(riga[2]);
	utentegenerico.setCodicefiscale(riga[3]);
	utentegenerico.setVia(riga[4]);
	utentegenerico.setCittaresidenza(riga[5]);
	utentegenerico.setUsername(riga[6]);
	utentegenerico.setPass(riga[7]);
	utentegenerico.setNumerotelefono(riga[8]);
	utentegenerico.setIndirizzomail(riga[9]);
	Tipoutente.TrovaperTipoutente(riga[10]);
	return uatt;
}
public Utenteinattesa CercaperIndirizzomail(String indirizzomail) {
	
	Utenteinattesa uatt = new Utenteinattesa();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE indirizzomail='"+indirizzomail+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
	Utentegenerico utentegenerico = new Utentegenerico();
	utentegenerico.setNome(riga[1]);
	utentegenerico.setCognome(riga[2]);
	utentegenerico.setCodicefiscale(riga[3]);
	utentegenerico.setVia(riga[4]);
	utentegenerico.setCittaresidenza(riga[5]);
	utentegenerico.setUsername(riga[6]);
	utentegenerico.setPass(riga[7]);
	utentegenerico.setNumerotelefono(riga[8]);
	utentegenerico.setIndirizzomail(riga[9]);
	Tipoutente.TrovaperTipoutente(riga[10]);
	return uatt;
}

public Utenteinattesa CercaperCittaresidenza(String cittaresidenza) {
	
	Utenteinattesa uatt = new Utenteinattesa();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM utenteinattesa WHERE cittaresidenza='"+cittaresidenza+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	uatt.setCodiceregistrazione(Integer.parseInt(riga[0]));
	Utentegenerico utentegenerico = new Utentegenerico();
	utentegenerico.setNome(riga[1]);
	utentegenerico.setCognome(riga[2]);
	utentegenerico.setCodicefiscale(riga[3]);
	utentegenerico.setVia(riga[4]);
	utentegenerico.setCittaresidenza(riga[5]);
	utentegenerico.setUsername(riga[6]);
	utentegenerico.setPass(riga[7]);
	utentegenerico.setNumerotelefono(riga[8]);
	utentegenerico.setIndirizzomail(riga[9]);
	Tipoutente.TrovaperTipoutente(riga[10]);
	return uatt;
}
	}


