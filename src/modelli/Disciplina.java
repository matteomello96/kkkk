package modelli;


import java.io.IOException;

import dao.DisciplinaDAO;



public class Disciplina {
	private String nomedisciplina;
	private String descrizione;
	private float costomensile;
	private int maxiscrittiturno;
	private Object immagine;
	private Calendario calendario;
	private Livello livello;


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

	public float getCostomensile() {
		return costomensile;
	}

	public void setCostomensile(float costomensile) {
		this.costomensile = costomensile;
	}

	public int getMaxiscrittiturno() {
		return maxiscrittiturno;
	}

	public void setMaxiscrittiturno(int maxiscrittiturno) {
		this.maxiscrittiturno = maxiscrittiturno;
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

	public Livello getLivello() {
		return livello;
	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}
	public static Disciplina CercaDisciplinaperNome(String nomedisciplina) throws IOException {
		return DisciplinaDAO.getInstance().CercaperNome(nomedisciplina);
	}
}
