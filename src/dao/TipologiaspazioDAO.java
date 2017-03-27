package dao;
import java.util.ArrayList;
	import modelli.Tipologiaspazio;
	import modelli.Spazio;
	import connessioneDB.DbConnection;

public class TipologiaspazioDAO {

		private static TipologiaspazioDAO instance;
		
		public static synchronized TipologiaspazioDAO getInstance() {
			if(instance == null)
				instance = new TipologiaspazioDAO();
			return instance;
		}
		
		public Tipologiaspazio CercaperNome(String nometipologia) {

			Tipologiaspazio ts = new Tipologiaspazio();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tipologiaspazio WHERE nometipologia='"+nometipologia+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ts.setNometipologia(riga[0]);
			Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
			ts.setSpazio(spazio);
			
			
			
			
			return ts;
		}
		
		public Tipologiaspazio CercaperSpazio(Spazio spazio) {

			Tipologiaspazio ts = new Tipologiaspazio();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM tipologiaspazio WHERE spazio='"+spazio+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ts.setNometipologia(riga[0]);
			Spazio spa = SpazioDAO.getInstance().CercaperNome(riga[4]);
			ts.setSpazio(spa);
			
			
			
			
			return ts;
		}
	}

