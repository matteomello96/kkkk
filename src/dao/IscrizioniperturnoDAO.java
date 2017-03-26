package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;
import modelli.Gestioneturno;
import modelli.Tesserato;
import modelli.Iscrizioniperturno;




	public class IscrizioniperturnoDAO {

		private static IscrizioniperturnoDAO instance;
		
		public static synchronized IscrizioniperturnoDAO getInstance() {
			if(instance == null)
				instance = new IscrizioniperturnoDAO();
			return instance;
		}

		public Iscrizioniperturno CercaperCodiceturnotesserato(int codiceturnotesserato) throws IOException {
			
			Iscrizioniperturno iscrtur = new Iscrizioniperturno();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizioniperturno WHERE codiceturnotesserato='"+codiceturnotesserato+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			iscrtur.setCodiceturnotesserato(Integer.parseInt(riga[0]));
			
			Gestioneturno gestioneturno = GestioneturnoDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			iscrtur.setGestioneturno(gestioneturno);
		
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[2]));
			iscrtur.setTesserato(tesserato);
			
			return iscrtur;
		}
		
public Iscrizioniperturno CercaperCodiceturno(int codiceturno) throws IOException {
			
			Iscrizioniperturno iscrtur = new Iscrizioniperturno();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizioniperturno WHERE codiceturno='"+codiceturno+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			iscrtur.setCodiceturnotesserato(Integer.parseInt(riga[0]));
			
			Gestioneturno gestioneturno = GestioneturnoDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
			iscrtur.setGestioneturno(gestioneturno);
		
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[2]));
			iscrtur.setTesserato(tesserato);
			
			return iscrtur;
		}
public Iscrizioniperturno CercaperTesserato(int matricolatesserato) throws IOException {
	
	Iscrizioniperturno iscrtur = new Iscrizioniperturno();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizioniperturno WHERE tesserato='"+matricolatesserato+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	iscrtur.setCodiceturnotesserato(Integer.parseInt(riga[0]));
	
	Gestioneturno gestioneturno = GestioneturnoDAO.getInstance().CercaperCodice(Integer.parseInt(riga[3]));
	iscrtur.setGestioneturno(gestioneturno);

	Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[2]));
	iscrtur.setTesserato(tesserato);
	
	return iscrtur;
}



public boolean InserisciIscrizioniperturno(Iscrizioniperturno iscrizioniperturno) {
			
			
			String sql = "INSERT INTO iscrizioniperturno(codiceturno,tesserato) VALUES('" +iscrizioniperturno.getGestioneturno().getCodiceturno()+ "', "+iscrizioniperturno.getTesserato().getMatricolatesserato() +")";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}