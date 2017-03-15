package business;

import java.time.Year;

import modelli.Disciplina;
import modelli.Livello;
import modelli.Calendario;
public class ResponsabileBusiness {

	private static ResponsabileBusiness instance;
	
	public static synchronized ResponsabileBusiness getInstance() {
		if(instance == null)
			instance = new ResponsabileBusiness();
		return instance;
	}

 public Calendario InserisciCalendario(String nomecalendario, Year annovalidita) {
	

	
	Calendario calendario = new Calendario();
	calendario.setNomecalendario(nomecalendario);
	calendario.setAnnovalidita(annovalidita);
	
	
	boolean esito = calendario.InserisciCalendario();
	if(esito)
		return calendario;
	else{
		System.out.println("Si e' verificato un errore");
		return null;
	}
	}
 public Disciplina InserisciDisciplina(String nomedisciplina, String descrizione,Object immagine,String nomecalendario) {
		
		Calendario calendario = Calendario.CercaCalendarioperNome(nomecalendario);
		
		
		Disciplina disciplina = new Disciplina();
		disciplina.setNomedisciplina(nomedisciplina);
		disciplina.setDescrizione(descrizione);
		disciplina.setImmagine(immagine);
		disciplina.setCalendario(calendario);
		
		boolean esito = disciplina.InserisciDisciplina();
		if(esito)
			return disciplina;
		else{
			System.out.println("Si e' verificato un errore");
			return null;
		}
}
 public Livello InserisciLivello(String nomelivello) {
		
		
		
		
		Livello livello = new Livello();
		livello.setNomelivello(nomelivello);
		
		
		boolean esito = livello.InserisciLivello();
		if(esito)
			return livello;
		else{
			System.out.println("Si e' verificato un errore");
			return null;
		}
}
}
