package dao;

import java.util.ArrayList;

import connessioneDB.DbConnection;
import modelli.Istruttore;
import modelli.Utentegenerico;

	public class IstruttoreDAO {

		private static IstruttoreDAO instance;
		
		public static synchronized IstruttoreDAO getInstance() {
			if(instance == null)
				instance = new IstruttoreDAO();
			return instance;
		}

		public Istruttore CercaperMatricola(int matricolaistruttore) {
			
			Istruttore istr = new Istruttore();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE matricolaistruttore='"+matricolaistruttore+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
			return istr;
		}
public Istruttore CercaperNome(String nome) {
			
			Istruttore istr = new Istruttore();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE nome='"+nome+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
			return istr;
		}

public Istruttore CercaperCognome(String cognome) {
	
	Istruttore istr = new Istruttore();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE cognome='"+cognome+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
	return istr;
}

public Istruttore CercaperVia(String via) {
	
	Istruttore istr = new Istruttore();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE via='"+via+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
	return istr;
}
public Istruttore CercaperNumerocivico(String numerocivico) {
	
	Istruttore istr = new Istruttore();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE numerocivico='"+numerocivico+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
	return istr;
}
public Istruttore CercaperIndirizzomail(String indirizzomail) {
	
	Istruttore istr = new Istruttore();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE indirizzomail='"+indirizzomail+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
	return istr;
}

public Istruttore CercaperCittaresidenza(String cittaresidenza) {
	
	Istruttore istr = new Istruttore();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttore WHERE cittaresidenza='"+cittaresidenza+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istr.setMatricolaistruttore(Integer.parseInt(riga[0]));
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
	return istr;
}
	}


