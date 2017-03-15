package dao;


import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;

import dao.CalendarioDAO;
import modelli.Calendario;
import modelli.Disciplina;





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
			
			dis.setImmagine((Object)riga[3]);
			Calendario calendario = CalendarioDAO.getInstance().CercaperNome(riga[4]);
			dis.setCalendario(calendario);
			

			
			return dis;
		}
public boolean InserisciDisciplina(Disciplina disciplina) {
			
			//nomecalendario,annovalidita
			String sql = "INSERT INTO disciplina VALUES('" +disciplina.getNomedisciplina()+ "', "+ disciplina.getDescrizione() +",'" +disciplina.getImmagine()+ "','" +disciplina.getCalendario().getNomecalendario()+ "', )";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}


