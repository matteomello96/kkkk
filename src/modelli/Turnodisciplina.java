package modelli;

import java.io.IOException;

import dao.TurnodisciplinaDAO;

public class Turnodisciplina {
	private int numeroturno;
	private Fasciaoraria fasciaoraria;
	private Giornosettimana giornosettimana;
	private Spazio spazio;
	private Istruttore istruttore;
	private Tesserato tesserato;
	private Disciplina disciplina;
	private Livello livello;
	public int getNumeroturno() {
		return numeroturno;
	}
	public void setNumeroturno(int numeroturno) {
		this.numeroturno = numeroturno;
	}
	public Fasciaoraria getFasciaoraria() {
		return fasciaoraria;
	}
	public void setFasciaoraria(Fasciaoraria fasciaoraria) {
		this.fasciaoraria = fasciaoraria;
	}
	public Giornosettimana getGiornosettimana() {
		return giornosettimana;
	}
	public void setGiornosettimana(Giornosettimana giornosettimana) {
		this.giornosettimana = giornosettimana;
	}
	public Spazio getSpazio() {
		return spazio;
	}
	public void setSpazio(Spazio spazio) {
		this.spazio = spazio;
	}
	public Istruttore getIstruttore() {
		return istruttore;
	}
	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}
	public Tesserato getTesserato() {
		return tesserato;
	}
	public void setTesserato(Tesserato tesserato) {
		this.tesserato = tesserato;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Livello getLivello() {
		return livello;
	}
	public void setLivello(Livello livello) {
		this.livello = livello;
	}
	
	public static Turnodisciplina CercaturnoperNumero(int numeroturno) throws IOException {
		return TurnodisciplinaDAO.getInstance().CercaperNumero(numeroturno);
	}
	
	}
	

