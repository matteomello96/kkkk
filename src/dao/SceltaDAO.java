package dao;


import java.util.ArrayList;
import modelli.Scelta;
import connessioneDB.DbConnection;


public class SceltaDAO {
	private static SceltaDAO instance;
	
	public static synchronized SceltaDAO getInstance() {
		if(instance == null)
			instance = new SceltaDAO();
		return instance;
	}

	public Scelta MostraScelta(String scelta)  {
		
		Scelta s = new Scelta();
		
		ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT COLUMS FROM '"+scelta+"' ");
		
		if(result.size() == 0) return null;
		
		String[] riga = result.get(0);
		
		s.setScelta(riga[0]);
		
		
		return s;
	}
	
	
}
