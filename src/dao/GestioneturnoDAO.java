package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;
import modelli.Giornosettimana;
import modelli.Fasciaoraria;
import modelli.Disciplinedisponibili;
import modelli.Spazio;
import modelli.Gestioneturno;




	public class GestioneturnoDAO {

		private static GestioneturnoDAO instance;
		
		public static synchronized GestioneturnoDAO getInstance() {
			if(instance == null)
				instance = new GestioneturnoDAO();
			return instance;
		}

		public Gestioneturno CercaperCodice(int codiceturno) throws IOException {
			
			Gestioneturno gestur = new Gestioneturno();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gestioneturno WHERE codiceturno='"+codiceturno+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			gestur.setCodiceturno(Integer.parseInt(riga[0]));
			Fasciaoraria.TrovaperFasciaOraria(riga[1]);
			Giornosettimana.TrovaperGiornosettimana(riga[2]);
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[3]));
			gestur.setDisciplinedisponibili(disciplinedisponibili);
		
			Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
			gestur.setSpazio(spazio);
			
			return gestur;
		}
		
public Gestioneturno CercaperFasciaoraria(Fasciaoraria fasciaoraria) throws IOException {
			
	        Gestioneturno gestur = new Gestioneturno();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gestioneturno WHERE fasciaoraria='"+fasciaoraria+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			gestur.setCodiceturno(Integer.parseInt(riga[0]));
			Fasciaoraria.TrovaperFasciaOraria(riga[1]);
			Giornosettimana.TrovaperGiornosettimana(riga[2]);
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[3]));
			gestur.setDisciplinedisponibili(disciplinedisponibili);
		
			Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
			gestur.setSpazio(spazio);
			
			return gestur;
		}

public Gestioneturno CercaperGiornosettimana(Giornosettimana giornosettimana) throws IOException {
	
    Gestioneturno gestur = new Gestioneturno();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gestioneturno WHERE giornosettimana='"+giornosettimana+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	gestur.setCodiceturno(Integer.parseInt(riga[0]));
	Fasciaoraria.TrovaperFasciaOraria(riga[1]);
	Giornosettimana.TrovaperGiornosettimana(riga[2]);
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[3]));
	gestur.setDisciplinedisponibili(disciplinedisponibili);

	Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
	gestur.setSpazio(spazio);
	
	return gestur;
}
public Gestioneturno CercaperCombinazionelivdis(int combinazionelivdis) throws IOException {
	
    Gestioneturno gestur = new Gestioneturno();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gestioneturno WHERE combinazionelivdis='"+combinazionelivdis+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	gestur.setCodiceturno(Integer.parseInt(riga[0]));
	Fasciaoraria.TrovaperFasciaOraria(riga[1]);
	Giornosettimana.TrovaperGiornosettimana(riga[2]);
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[3]));
	gestur.setDisciplinedisponibili(disciplinedisponibili);

	Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
	gestur.setSpazio(spazio);
	
	return gestur;
}

public Gestioneturno CercaperSpazio(String nomespazio) throws IOException {
	
    Gestioneturno gestur = new Gestioneturno();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gestioneturno WHERE spazio='"+nomespazio+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	gestur.setCodiceturno(Integer.parseInt(riga[0]));
	Fasciaoraria.TrovaperFasciaOraria(riga[1]);
	Giornosettimana.TrovaperGiornosettimana(riga[2]);
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[3]));
	gestur.setDisciplinedisponibili(disciplinedisponibili);

	Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[4]);
	gestur.setSpazio(spazio);
	
	return gestur;
}





public boolean InserisciTurno(Gestioneturno gestioneturno) {
			
			
			String sql = "INSERT INTO gestioneturno(fasciaoraria,giornosettimana,combinazionelivdis,spazio) VALUES('" +gestioneturno.getFasciaoraria()+ "', "+ gestioneturno.getGiornosettimana() +",'" +gestioneturno.getDisciplinedisponibili().getCombinazionelivdis()+ "', '"+gestioneturno.getSpazio().getNomespazio()+ "')";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}