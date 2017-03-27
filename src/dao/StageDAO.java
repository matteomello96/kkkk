package dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Stage;
import modelli.Evento;
import modelli.Infopagamento;
import modelli.Disciplinedisponibili;
import modelli.Istruttore;

	public class StageDAO {

		private static StageDAO instance;
		
		public static synchronized StageDAO getInstance() {
			if(instance == null)
				instance = new StageDAO();
			return instance;
		}
public Stage CercaperCodice(int stage) throws  IOException {
			
			Stage st = new Stage();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE stage='"+stage+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			st.setCodicestage(Integer.parseInt(riga[0]));
			Evento evento= new Evento();
			evento.setNomeevento(riga[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[2] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			st.setDataevento(data);
			evento.setDescrizione(riga[3]);
			Infopagamento.TrovaperInfopagamento(riga[4]);
			evento.setCostoevento(Float.parseFloat((riga[5])));
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
			st.setDisciplinedisponibili(disciplinedisponibili);
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
			st.setIstruttore(istruttore);
			return st;
		}

		public Stage CercaperNomeevento(String nomeevento) throws  IOException {
			
			Stage st = new Stage();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE nomeevento='"+nomeevento+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			st.setCodicestage(Integer.parseInt(riga[0]));
			Evento evento= new Evento();
			evento.setNomeevento(riga[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[2] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			st.setDataevento(data);
			evento.setDescrizione(riga[3]);
			Infopagamento.TrovaperInfopagamento(riga[4]);
			evento.setCostoevento(Float.parseFloat((riga[5])));
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
			st.setDisciplinedisponibili(disciplinedisponibili);
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
			st.setIstruttore(istruttore);
			return st;
		}
		
public Stage CercaperDataevento(Date dataevento) throws  IOException {
			
			Stage st = new Stage();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE dataevento='"+dataevento+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			st.setCodicestage(Integer.parseInt(riga[0]));
			Evento evento= new Evento();
			evento.setNomeevento(riga[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[2] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			st.setDataevento(data);
			evento.setDescrizione(riga[3]);
			Infopagamento.TrovaperInfopagamento(riga[4]);
			evento.setCostoevento(Float.parseFloat((riga[5])));
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
			st.setDisciplinedisponibili(disciplinedisponibili);
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
			st.setIstruttore(istruttore);
			return st;
		}
public Stage CercaperInfopagamento(Infopagamento infopagamento) throws  IOException {
	
	Stage st = new Stage();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE infopagamento='"+infopagamento+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	st.setCodicestage(Integer.parseInt(riga[0]));
	Evento evento= new Evento();
	evento.setNomeevento(riga[1]);
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	Date data= null;
	try {
	   data = sdf.parse(riga[2] );
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	st.setDataevento(data);
	evento.setDescrizione(riga[3]);
	Infopagamento.TrovaperInfopagamento(riga[4]);
	evento.setCostoevento(Float.parseFloat((riga[5])));
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
	st.setDisciplinedisponibili(disciplinedisponibili);
	Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
	st.setIstruttore(istruttore);
	return st;
}
public Stage CercaperCosto(float costoevento) throws  IOException {
	
	Stage st = new Stage();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE costoevento='"+costoevento+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	st.setCodicestage(Integer.parseInt(riga[0]));
	Evento evento= new Evento();
	evento.setNomeevento(riga[1]);
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	Date data= null;
	try {
	   data = sdf.parse(riga[2] );
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	st.setDataevento(data);
	evento.setDescrizione(riga[3]);
	Infopagamento.TrovaperInfopagamento(riga[4]);
	evento.setCostoevento(Float.parseFloat((riga[5])));
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
	st.setDisciplinedisponibili(disciplinedisponibili);
	Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
	st.setIstruttore(istruttore);
	return st;
}

public Stage CercaperIstruttore(Istruttore istruttore) throws  IOException {
	
	Stage st = new Stage();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE istruttore='"+istruttore+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	st.setCodicestage(Integer.parseInt(riga[0]));
	Evento evento= new Evento();
	evento.setNomeevento(riga[1]);
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	Date data= null;
	try {
	   data = sdf.parse(riga[2] );
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	st.setDataevento(data);
	evento.setDescrizione(riga[3]);
	Infopagamento.TrovaperInfopagamento(riga[4]);
	evento.setCostoevento(Float.parseFloat((riga[5])));
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
	st.setDisciplinedisponibili(disciplinedisponibili);
	Istruttore ist = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
	st.setIstruttore(ist);
	return st;
}


public Stage CercaperCombinazione(Disciplinedisponibili combinazionelivdis) throws  IOException {
	
	Stage st = new Stage();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE combinazionelivdis='"+combinazionelivdis+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	st.setCodicestage(Integer.parseInt(riga[0]));
	Evento evento= new Evento();
	evento.setNomeevento(riga[1]);
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	Date data= null;
	try {
	   data = sdf.parse(riga[2] );
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	st.setDataevento(data);
	evento.setDescrizione(riga[3]);
	Infopagamento.TrovaperInfopagamento(riga[4]);
	evento.setCostoevento(Float.parseFloat((riga[5])));
	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[6]));
	st.setDisciplinedisponibili(disciplinedisponibili);
	Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
	st.setIstruttore(istruttore);
	return st;
}

	}


