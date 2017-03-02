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
	}


