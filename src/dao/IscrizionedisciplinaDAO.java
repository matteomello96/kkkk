package dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Disciplinedisponibili;
import modelli.Iscrizionedisciplina;
import modelli.Modalitapagamento;
import modelli.Tesserato;
import modelli.Iscrizioneevento;
import modelli.Fasciaoraria;
import modelli.Iscrizioneevento;


	public class IscrizionedisciplinaDAO {

		private static IscrizionedisciplinaDAO instance;
		
		public static synchronized IscrizionedisciplinaDAO getInstance() {
			if(instance == null)
				instance = new IscrizionedisciplinaDAO();
			return instance;
		}

		public Iscrizionedisciplina CercaperCodice(int codiceiscrizionedisciplina) throws IOException {
			
			Iscrizionedisciplina isd = new Iscrizionedisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+codiceiscrizionedisciplina+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			isd.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			iscrizioneevento.setDataazione(data);
			Fasciaoraria.TrovaperFasciaOraria(riga[2]);
			
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[4]));
			iscrizioneevento.setTesserato(tesserato);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[5]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			return isd;
		}
		
		
		public Iscrizionedisciplina CercaperModalitapagamento(Modalitapagamento modalitapagamento) throws IOException {
			
			Iscrizionedisciplina isd = new Iscrizionedisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionedisciplina WHERE modalitapagamento='"+modalitapagamento+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			isd.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			iscrizioneevento.setDataazione(data);
			Fasciaoraria.TrovaperFasciaOraria(riga[2]);
			
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[4]));
			iscrizioneevento.setTesserato(tesserato);
			Modalitapagamento modpagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[5]);
			iscrizioneevento.setModalitapagamento(modpagamento);
			return isd;
		}
		
	public Iscrizionedisciplina CercaperCombinazionelivdis(Disciplinedisponibili combinazionelivdis) throws IOException {
			
			Iscrizionedisciplina isd = new Iscrizionedisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionedisciplina WHERE combinazionelivdis='"+combinazionelivdis+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			isd.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			iscrizioneevento.setDataazione(data);
			Fasciaoraria.TrovaperFasciaOraria(riga[2]);
			
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[4]));
			iscrizioneevento.setTesserato(tesserato);
			Modalitapagamento modpagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[5]);
			iscrizioneevento.setModalitapagamento(modpagamento);
			return isd;
		}
		
		
		
		
public boolean InserisciIscrizionedisciplina(Iscrizionedisciplina iscrizionedisciplina) {
			
			//nomecalendario,annovalidita
			String sql = "INSERT INTO iscrizionedisciplina(tesserato,modalitapagamento,combinazionelivdis) VALUES('" +iscrizionedisciplina.getTesserato()+ "', "+ iscrizionedisciplina.getModalitapagamento() +",'" +iscrizionedisciplina.getDisciplinedisponibili().getCombinazionelivdis()+ "')";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
	}


