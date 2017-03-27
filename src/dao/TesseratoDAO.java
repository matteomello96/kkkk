package dao;

import java.util.ArrayList;

import connessioneDB.DbConnection;
import modelli.Istruttore;
import modelli.Tesserato;
import modelli.Utentegenerico;

	public class TesseratoDAO {

		private static TesseratoDAO instance;
		
		public static synchronized TesseratoDAO getInstance() {
			if(instance == null)
				instance = new TesseratoDAO();
			return instance;
		}

		public Tesserato CercaperMatricola(int matricolatesserato) {
			
			Tesserato t = new Tesserato(null, null);
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE matricolatesserato='"+matricolatesserato+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
			return t;
		}
		
		
public Tesserato CercaperNome(String nome) {
			
	         Tesserato t = new Tesserato(null, null);
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE nome='"+nome+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
			return t;
		}



public Tesserato CercaperCognome(String cognome) {
	
	Tesserato t = new Tesserato(null,null);
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE cognome='"+cognome+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
	return t;
}

public Tesserato CercaperVia(String via) {
	
	Tesserato t = new Tesserato(null, null);
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE via='"+via+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
	return t;
}
public Tesserato CercaperNumerocivico(String numerocivico) {
	
	Tesserato t = new Tesserato(null, null);
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE numerocivico='"+numerocivico+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
	return t;
}
public Tesserato CercaperIndirizzomail(String indirizzomail) {
	
	Tesserato t = new Tesserato(null, null);
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE indirizzomail='"+indirizzomail+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
	return t;
}

public Tesserato CercaperCittaresidenza(String cittaresidenza) {
	
	Tesserato t = new Tesserato(null, null);
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tesserato WHERE cittaresidenza='"+cittaresidenza+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	t.setMatricolatesserato(Integer.parseInt(riga[0]));
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
	return t;
}
		
		
		
		public boolean TesseratoEsiste (Tesserato t)
		{
			String username = t.getUsername();
			String pass =t.getPass();
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT username,pass FROM tesserato WHERE username='"+username+"' and pass='"+pass+"' ");
			
			
			if(result.isEmpty()) 
				return(false);
			else
				return(true);
		}

	}


