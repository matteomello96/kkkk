package dao;
import java.time.Year;
import java.util.ArrayList;
	import modelli.Calendario;
	import connessioneDB.DbConnection;


public class CalendarioDAO {

		private static CalendarioDAO instance;
		
		public static synchronized CalendarioDAO getInstance() {
			if(instance == null)
				instance = new CalendarioDAO();
			return instance;
		}
		
		public Calendario CercaperNome(String nomecalendario) {

			Calendario cal = new Calendario();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM calendario WHERE nomecalendario='"+nomecalendario+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			cal.setNomecalendario(riga[0]);
			cal.setAnnovalidita(Year.parse(riga[1]));
			
			
			
			return cal;
		}
		public Calendario CercaperAnnoValidita(Year annovalidita) {

			Calendario cal = new Calendario();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM calendario WHERE annovalidita='"+annovalidita+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			cal.setNomecalendario(riga[0]);
			cal.setAnnovalidita(Year.parse(riga[1]));
			
			
			
			return cal;
		}
		public boolean InserisciCalendario(Calendario calendario) {
			
			//nomecalendario,annovalidita
			String sql = "INSERT INTO calendario VALUES('" +calendario.getNomecalendario()+ "', "+ calendario.getAnnovalidita() +" )";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
	}
