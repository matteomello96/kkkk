package dao;

import java.io.IOException;

import java.util.ArrayList;


import connessioneDB.DbConnection;


import modelli.Livello;
import modelli.Disciplina;
import modelli.Disciplinedisponibili;





	public class DisciplinedisponibiliDAO {

		private static DisciplinedisponibiliDAO instance;
		
		public static synchronized DisciplinedisponibiliDAO getInstance() {
			if(instance == null)
				instance = new DisciplinedisponibiliDAO();
			return instance;
		}

		public Disciplinedisponibili CercaperDisciplina(String disciplina) throws IOException {
			
			Disciplinedisponibili disdis = new Disciplinedisponibili();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM disciplinedisponibili WHERE disciplina='"+disciplina+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			disdis.setCombinazionelivdis(Integer.parseInt(riga[0]));
			Livello livello = LivelloDAO.getInstance().CercaperNome(riga[1]);
			disdis.setLivello(livello);
		
			Disciplina nomedisciplina = DisciplinaDAO.getInstance().CercaperNome(riga[2]);
			disdis.setDisciplina(nomedisciplina);
			disdis.setMaxiscrittiturno(Integer.parseInt(riga[3]));
			disdis.setCostomensile(Integer.parseInt(riga[4]));
			
			return disdis;
		}
		
public Disciplinedisponibili CercaperLivello(String livello) throws IOException {
			
			Disciplinedisponibili disdis = new Disciplinedisponibili();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM disciplinedisponibili WHERE livello='"+livello+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			disdis.setCombinazionelivdis(Integer.parseInt(riga[0]));
			Livello nomelivello = LivelloDAO.getInstance().CercaperNome(riga[1]);
			disdis.setLivello(nomelivello);
		
			Disciplina nomedisciplina = DisciplinaDAO.getInstance().CercaperNome(riga[2]);
			disdis.setDisciplina(nomedisciplina);
			disdis.setMaxiscrittiturno(Integer.parseInt(riga[3]));
			disdis.setCostomensile(Integer.parseInt(riga[4]));
			
			return disdis;
		}
public Disciplinedisponibili CercaperCombinazione(int combinazione) throws IOException {
	
	Disciplinedisponibili disdis = new Disciplinedisponibili();
	
	ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM disciplinedisponibili WHERE combinazionelivdis='"+combinazione+"' ");
	
	if(result.size() == 0) return null;
	
	String[] riga = result.get(0);
	
	disdis.setCombinazionelivdis(Integer.parseInt(riga[0]));
	Livello livello = LivelloDAO.getInstance().CercaperNome(riga[1]);
	disdis.setLivello(livello);

	Disciplina nomedisciplina = DisciplinaDAO.getInstance().CercaperNome(riga[2]);
	disdis.setDisciplina(nomedisciplina);
	disdis.setMaxiscrittiturno(Integer.parseInt(riga[3]));
	disdis.setCostomensile(Integer.parseInt(riga[4]));
	
	return disdis;
}
public boolean InserisciCombinazionelivdis(Disciplinedisponibili disciplinedisponibili) {
			
			//nomecalendario,annovalidita
			String sql = "INSERT INTO disciplinedisponibili VALUES('" +disciplinedisponibili.getCombinazionelivdis()+ "', "+ disciplinedisponibili.getDisciplina().getNomedisciplina() +",'" +disciplinedisponibili.getLivello().getNomelivello()+ "', '" +disciplinedisponibili.getMaxiscrittiturno()+ "','" +disciplinedisponibili.getCostomensile()+ "')";
			System.out.println(sql);
			return DbConnection.getInstance().eseguiAggiornamento(sql);
			
		}
		
	}


