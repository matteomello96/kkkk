package modelli;

import java.io.IOException;

import dao.IscrizionedisciplinaDAO;


public class Iscrizionedisciplina extends Iscrizioneevento{

	private int codiceiscrizionedisciplina;
	private Fasciaoraria fasciapreferita;
	private Disciplina disciplina;
	public int getCodiceiscrizionedisciplina() {
		return codiceiscrizionedisciplina;
	}
	public void setCodiceiscrizionedisciplina(int codiceiscrizionedisciplina) {
		this.codiceiscrizionedisciplina = codiceiscrizionedisciplina;
	}
	public Fasciaoraria getFasciapreferita() {
		return fasciapreferita;
	}
	public void setFasciapreferita(Fasciaoraria fasciapreferita) {
		this.fasciapreferita = fasciapreferita;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public static Iscrizionedisciplina cercaIscrizionedisciplinaperCodice(int codiceiscrizionedisciplina) throws IOException {
		return IscrizionedisciplinaDAO.getInstance().CercaperCodice(codiceiscrizionedisciplina);
	}
	
	
}
