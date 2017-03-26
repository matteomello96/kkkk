package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;

import modelli.Fasciaoraria;
import modelli.Iscrizionedisciplina;
import modelli.Sceltaorariperiscrizione;




	public class SceltaorariperiscrizioneDAO {

		private static SceltaorariperiscrizioneDAO instance;
		
		public static synchronized SceltaorariperiscrizioneDAO getInstance() {
			if(instance == null)
				instance = new SceltaorariperiscrizioneDAO();
			return instance;
		}

		public Sceltaorariperiscrizione CercaperCodiceiscrizionedisciplina(int codiceiscrizionedisc) throws IOException {
			
			Sceltaorariperiscrizione sceltaor = new Sceltaorariperiscrizione();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM sceltaorariperiscrizione WHERE codiceiscrizionedisciplina='"+codiceiscrizionedisc+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			Fasciaoraria.TrovaperFasciaOraria(riga[0]);
			
			Iscrizionedisciplina iscrizionedisciplina = IscrizionedisciplinaDAO.getInstance().CercaperCodice(Integer.parseInt(riga[1]));
			sceltaor.setIscrizionedisciplina(iscrizionedisciplina);
		
			
			
			return sceltaor;
		}
		
public Sceltaorariperiscrizione CercaperPreferenzafascia(Fasciaoraria preferenzafascia) throws IOException {
			
			Sceltaorariperiscrizione sceltaor = new Sceltaorariperiscrizione();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM sceltaorariperiscrizione WHERE preferenzafascia='"+preferenzafascia+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			Fasciaoraria.TrovaperFasciaOraria(riga[0]);
			
			Iscrizionedisciplina iscrizionedisciplina = IscrizionedisciplinaDAO.getInstance().CercaperCodice(Integer.parseInt(riga[1]));
			sceltaor.setIscrizionedisciplina(iscrizionedisciplina);
		
			
			
			return sceltaor;
		}

public boolean InserisciSceltaorariperiscrizione (Sceltaorariperiscrizione sceltaorariperiscrizione) {
			
			
			String sql = "INSERT INTO istruttoridisponibiliperdisciplina(preferenzafascia,codiceiscrizionedisciplina) VALUES('" +sceltaorariperiscrizione.getPreferenzafascia()+ "', "+sceltaorariperiscrizione.getIscrizionedisciplina().getCodiceiscrizionedisciplina() +")";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}