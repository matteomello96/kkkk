package dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Disciplina;
import modelli.Iscrizionedisciplina;
import modelli.Modalitapagamento;
import modelli.Tesserato;
import modelli.Iscrizioneevento;
import modelli.Fasciaoraria;


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
			Disciplina disciplina = DisciplinaDAO.getInstance().CercaperNome(riga[3]);
			isd.setDisciplina(disciplina);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[4]));
			iscrizioneevento.setTesserato(tesserato);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[5]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			return isd;
		}
	}


