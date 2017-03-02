package dao;
import java.util.ArrayList;
	import modelli.Spazio;
	import connessioneDB.DbConnection;

public class SpazioDAO {

		private static SpazioDAO instance;
		
		public static synchronized SpazioDAO getInstance() {
			if(instance == null)
				instance = new SpazioDAO();
			return instance;
		}
		
		public Spazio CercaperNome(String nomespazio) {

			Spazio sp = new Spazio();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM spazio WHERE nomespazio='"+nomespazio+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			sp.setNomespazio(riga[0]);
			
			
			
			
			return sp;
		}
	}

