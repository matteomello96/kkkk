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

		public Stage CercaperCodice(int codicestage) throws  IOException {
			
			Stage st = new Stage();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM stage WHERE codicestage='"+codicestage+"' ");
			
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


