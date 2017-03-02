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
	}


