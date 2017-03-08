package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Gara;
import modelli.Evento;
import modelli.Infopagamento;
import modelli.Livello;
import modelli.Istruttore;

	public class GaraDAO {

		private static GaraDAO instance;
		
		public static synchronized GaraDAO getInstance() {
			if(instance == null)
				instance = new GaraDAO();
			return instance;
		}

		public Gara CercaperCodice(int codicegara) {
			
			Gara g = new Gara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM gara WHERE codicegara='"+codicegara+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			g.setCodicegara(Integer.parseInt(riga[0]));
			Evento evento= new Evento();
			evento.setNomeevento(riga[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[2] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			g.setDataevento(data);
			evento.setDescrizione(riga[3]);
			Infopagamento.TrovaperInfopagamento(riga[4]);
			evento.setCostoevento(Float.parseFloat((riga[5])));
			Livello livello = LivelloDAO.getInstance().CercaperNome(riga[6]);
			g.setLivello(livello);
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[7])));
			g.setIstruttore(istruttore);
			return g;
		}
	}

