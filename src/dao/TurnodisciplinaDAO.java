package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;

import modelli.Disciplina;
import modelli.Turnodisciplina;
import modelli.Fasciaoraria;

import modelli.Spazio;
import modelli.Tesserato;
import modelli.Istruttore;
import modelli.Giornosettimana;
import modelli.Livello;


	public class TurnodisciplinaDAO {

		private static TurnodisciplinaDAO instance;
		
		public static synchronized TurnodisciplinaDAO getInstance() {
			if(instance == null)
				instance = new TurnodisciplinaDAO();
			return instance;
		}

		public Turnodisciplina CercaperNumero(int numeroturno) throws IOException {
			
			Turnodisciplina td = new Turnodisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM turnodisciplina WHERE numeroturno='"+numeroturno+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			td.setNumeroturno(Integer.parseInt(riga[0]));
			Fasciaoraria.TrovaperFasciaOraria(riga[1]);
			Giornosettimana.TrovaperGiornosettimana(riga[2]);
			Spazio spazio = SpazioDAO.getInstance().CercaperNome(riga[3]);
			td.setSpazio(spazio);
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt((riga[4])));
			td.setIstruttore(istruttore);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[5]));
			td.setTesserato(tesserato);
			Disciplina disciplina = DisciplinaDAO.getInstance().CercaperNome(riga[6]);
			td.setDisciplina(disciplina);
			Livello livello = LivelloDAO.getInstance().CercaperNome(riga[7]);
			td.setLivello(livello);
			
			
			return td;
		}
	}


