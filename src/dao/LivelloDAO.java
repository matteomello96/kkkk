package dao;
import java.util.ArrayList;
	import modelli.Livello;
	import connessioneDB.DbConnection;

public class LivelloDAO {

		private static LivelloDAO instance;
		
		public static synchronized LivelloDAO getInstance() {
			if(instance == null)
				instance = new LivelloDAO();
			return instance;
		}
		
		public Livello CercaperNome(String nomelivello) {

			Livello liv = new Livello();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM livello WHERE nomelivello='"+nomelivello+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			liv.setNomelivello(riga[0]);
			
			
			
			
			return liv;
		}
	}

