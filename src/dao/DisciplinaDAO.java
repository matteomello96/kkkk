package dao;


import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;


import modelli.Calendario;
import modelli.Disciplina;
import modelli.Livello;




	public class DisciplinaDAO {

		private static DisciplinaDAO instance;
		
		public static synchronized DisciplinaDAO getInstance() {
			if(instance == null)
				instance = new DisciplinaDAO();
			return instance;
		}

		public Disciplina CercaperNome(String nomedisciplina) throws IOException {
			
			Disciplina dis = new Disciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM disciplina WHERE nomedisciplina='"+nomedisciplina+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			dis.setNomedisciplina(riga[0]);
			dis.setCostomensile(Float.parseFloat(riga[1]));
			dis.setMaxiscrittiturno(Integer.parseInt(riga[2]));
			dis.setImmagine((Object)riga[3]);
			Calendario calendario = CalendarioDAO.getInstance().CercaperNome(riga[4]);
			dis.setCalendario(calendario);
			Livello livello = LivelloDAO.getInstance().CercaperNome(riga[5]);
			dis.setLivello(livello);
			
			return dis;
		}
	}


