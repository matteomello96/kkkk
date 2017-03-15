package modelli;


import java.io.IOException;

import dao.DisciplinaDAO;




public class Disciplina {
	private String nomedisciplina;
	private String descrizione;
	
	
	private Object immagine;
	private Calendario calendario;
	


	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Object getImmagine() {
		return this.immagine;
	}

	public void setImmagine(Object immagine) {
		this.immagine = immagine;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public boolean InserisciDisciplina() {
		return DisciplinaDAO.getInstance().InserisciDisciplina(this);
	}
	public static Disciplina CercaDisciplinaperNome(String nomedisciplina) throws IOException {
		return DisciplinaDAO.getInstance().CercaperNome(nomedisciplina);
	}
}
