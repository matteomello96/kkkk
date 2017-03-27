package dao;

import java.util.ArrayList;

import connessioneDB.DbConnection;
import modelli.Responsabilecentro;
import modelli.Utentegenerico;

	public class ResponsabilecentroDAO {

		private static ResponsabilecentroDAO instance;
		
		public static synchronized ResponsabilecentroDAO getInstance() {
			if(instance == null)
				instance = new ResponsabilecentroDAO();
			return instance;
		}

		public Responsabilecentro CercaperMatricola(int matricolaresponsabile) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE matricolaresponsabile='"+matricolaresponsabile+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		public Responsabilecentro Cercapernome(String nome) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE nome='"+nome+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		public Responsabilecentro CercaperCognome(String cognome) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE cognome='"+cognome+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		public Responsabilecentro CercaperCodicefiscale(String codicefiscale) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE codicefiscale='"+codicefiscale+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		public Responsabilecentro CercaperIndirizzomail(String indirizzomail) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE indirizzomail='"+indirizzomail+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		public Responsabilecentro CercaperNumerocivico(String numerocivico) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE numerocivico='"+numerocivico+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}		
		
		public Responsabilecentro CercaperVia(String via) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE via='"+via+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}		
		
		public Responsabilecentro CercaperCittaresidenza(String cittaresidenza) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE cittaresidenza='"+cittaresidenza+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
		
		
		public Responsabilecentro CercaperUsername(String username) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE username='"+username+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}	
		
		public Responsabilecentro CercaperNumerotelefono(String numerotelefono) {
			
			Responsabilecentro resp = new Responsabilecentro();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM responsabilecentro WHERE numerotelefono='"+numerotelefono+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			resp.setMatricolaresponsabile(Integer.parseInt(riga[0]));
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
			return resp;
		}
	}


