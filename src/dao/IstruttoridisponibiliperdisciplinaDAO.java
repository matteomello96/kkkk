package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;
import modelli.Istruttore;
import modelli.Disciplinedisponibili;
import modelli.Istruttoridisponibiliperdisciplina;




	public class IstruttoridisponibiliperdisciplinaDAO {

		private static IstruttoridisponibiliperdisciplinaDAO instance;
		
		public static synchronized IstruttoridisponibiliperdisciplinaDAO getInstance() {
			if(instance == null)
				instance = new IstruttoridisponibiliperdisciplinaDAO();
			return instance;
		}

		public Istruttoridisponibiliperdisciplina CercaperCombinazioneistrdis(int combinazioneistrdis) throws IOException {
			
			Istruttoridisponibiliperdisciplina istrdisp = new Istruttoridisponibiliperdisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttoridisponibiliperdisciplina WHERE combinazioneistrdis='"+combinazioneistrdis+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			istrdisp.setCombinazioneistrdis(Integer.parseInt(riga[0]));
			
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[1]));
			istrdisp.setIstruttore(istruttore);
		
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[2]));
			istrdisp.setDisciplinedisponibili(disciplinedisponibili);
			
			return istrdisp;
		}
		
public Istruttoridisponibiliperdisciplina CercaperIstruttore(int matricolaistruttore) throws IOException {
			
			Istruttoridisponibiliperdisciplina istrdisp = new Istruttoridisponibiliperdisciplina();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttoridisponibiliperdisciplina WHERE istruttore='"+matricolaistruttore+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			istrdisp.setCombinazioneistrdis(Integer.parseInt(riga[0]));
			
			Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[1]));
			istrdisp.setIstruttore(istruttore);
		
			Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[2]));
			istrdisp.setDisciplinedisponibili(disciplinedisponibili);
			
			return istrdisp;
		}
public Istruttoridisponibiliperdisciplina CercaperCombinazionelivdis(int combinazionelivdis) throws IOException {
	
	Istruttoridisponibiliperdisciplina istrdisp = new Istruttoridisponibiliperdisciplina();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM istruttoridisponibiliperdisciplina WHERE combinazionelivdis='"+combinazionelivdis+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	istrdisp.setCombinazioneistrdis(Integer.parseInt(riga[0]));
	
	Istruttore istruttore = IstruttoreDAO.getInstance().CercaperMatricola(Integer.parseInt(riga[1]));
	istrdisp.setIstruttore(istruttore);

	Disciplinedisponibili disciplinedisponibili = DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(Integer.parseInt(riga[2]));
	istrdisp.setDisciplinedisponibili(disciplinedisponibili);
	
	return istrdisp;
}

public boolean InserisciIstruttoridisponibiliperdisciplina (Istruttoridisponibiliperdisciplina istruttoridisponibiliperdisciplina) {
			
			
			String sql = "INSERT INTO istruttoridisponibiliperdisciplina(istruttore,combinazionelivdis) VALUES('" +istruttoridisponibiliperdisciplina.getIstruttore().getMatricolaistruttore()+ "', "+istruttoridisponibiliperdisciplina.getDisciplinedisponibili().getCombinazionelivdis() +")";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}