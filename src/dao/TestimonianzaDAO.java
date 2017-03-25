package dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connessioneDB.DbConnection;

import modelli.Disciplinedisponibili;
import modelli.Tesserato;
import modelli.Testimonianza;


	public class TestimonianzaDAO {

		private static TestimonianzaDAO instance;
		
		public static synchronized TestimonianzaDAO getInstance() {
			if(instance == null)
				instance = new TestimonianzaDAO();
			return instance;
		}

		public Testimonianza CercaperCodice(int codiceiscrizionedisciplina) throws IOException {
			
			Testimonianza text = new Testimonianza();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+codiceiscrizionedisciplina+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			text.setCodicetestimonianza(Integer.parseInt(riga[0]));
			text.setCommento(riga[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date data= null;
			try {
			   data = sdf.parse(riga[2] );
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
			text.setDataazione(data);
			Tesserato tesserato = TesseratoDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[3]));
			text.setTesserato(tesserato);
			
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[4]));
			text.setDisciplinedisponibili(disciplinedisponibili);
			
			
			return text;
		}
	}


