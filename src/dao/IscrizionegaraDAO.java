package dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Gara;
import modelli.Modalitapagamento;
import modelli.Tesserato;
import modelli.Iscrizioneevento;
import modelli.Iscrizionegara;


	public class IscrizionegaraDAO {

		private static IscrizionegaraDAO instance;
		
		public static synchronized IscrizionegaraDAO getInstance() {
			if(instance == null)
				instance = new IscrizionegaraDAO();
			return instance;
		}

		public Iscrizionegara CercaperCodice(int codiceiscrizionegara) throws IOException {
			
			Iscrizionegara ig = new Iscrizionegara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE codiceiscrizionegara='"+codiceiscrizionegara+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ig.setCodiceiscrizionegara(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			ig.readFile(riga[2]);
			iscrizioneevento.setDataazione(data);
			Gara gara = GaraDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			ig.setGara(gara);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[4]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			iscrizioneevento.setTesserato(tesserato);
			
			return ig;
		}
		public Iscrizionegara Cercapergara(Gara gara) throws IOException {
			
			Iscrizionegara ig = new Iscrizionegara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE gara='"+gara+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ig.setCodiceiscrizionegara(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			ig.readFile(riga[2]);
			iscrizioneevento.setDataazione(data);
			Gara ga = GaraDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			ig.setGara(ga);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[4]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			iscrizioneevento.setTesserato(tesserato);
			
			return ig;
		}
		public Iscrizionegara CercaperTesserato(Tesserato tesserato) throws IOException {
			
			Iscrizionegara ig = new Iscrizionegara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE tesserato='"+tesserato+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ig.setCodiceiscrizionegara(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			ig.readFile(riga[2]);
			iscrizioneevento.setDataazione(data);
			Gara gara = GaraDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			ig.setGara(gara);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[4]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			Tesserato tess = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			iscrizioneevento.setTesserato(tess);
			
			return ig;
		}
		public Iscrizionegara CercaperModalitapagamento(Modalitapagamento modalitapagamento) throws IOException {
			
			Iscrizionegara ig = new Iscrizionegara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE modalitapagamento='"+modalitapagamento+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ig.setCodiceiscrizionegara(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			ig.readFile(riga[2]);
			iscrizioneevento.setDataazione(data);
			Gara gara = GaraDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			ig.setGara(gara);
			Modalitapagamento modalitapagame = ModalitapagamentoDAO.getInstance().CercaperNome(riga[4]);
			iscrizioneevento.setModalitapagamento(modalitapagame);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			iscrizioneevento.setTesserato(tesserato);
			
			return ig;
		}
		
		public Iscrizionegara CercaperCertificato(String certificatorc) throws IOException {
			
			Iscrizionegara ig = new Iscrizionegara();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionegara WHERE certificatorc='"+certificatorc+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			ig.setCodiceiscrizionegara(Integer.parseInt(riga[0]));
			Iscrizioneevento iscrizioneevento= new Iscrizioneevento();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[1] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			ig.readFile(riga[2]);
			iscrizioneevento.setDataazione(data);
			Gara gara = GaraDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			ig.setGara(gara);
			Modalitapagamento modalitapagamento = ModalitapagamentoDAO.getInstance().CercaperNome(riga[4]);
			iscrizioneevento.setModalitapagamento(modalitapagamento);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			iscrizioneevento.setTesserato(tesserato);
			
			return ig;
		}
	}


