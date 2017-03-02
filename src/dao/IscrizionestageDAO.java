package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Stage;
import modelli.Modalitapagamento;
import modelli.Tesserato;
import modelli.Iscrizioneevento;
import modelli.Iscrizionestage;


	public class IscrizionestageDAO {

		private static IscrizionestageDAO instance;
		
		public static synchronized IscrizionestageDAO getInstance() {
			if(instance == null)
				instance = new IscrizionestageDAO();
			return instance;
		}

		public Iscrizionestage CercaperCodice(int codiceiscrizionestage) {
			
			Iscrizionestage is = new Iscrizionestage();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE codiceiscrizionestage='"+codiceiscrizionestage+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			is.setCodiceiscrizionestage(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			iscrizioneevento.setDataazione(data);
			Stage stage = StageDAO.getInstance().CercaperCodice(Integer.parseInt(riga[2]));
			is.setStage(stage);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[3]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[4]));
			iscrizioneevento.setTesserato(tesserato);
			
			return is;
		}
	}


