package modelli;

import java.io.IOException;

import dao.IscrizionedisciplinaDAO;


public class Iscrizionedisciplina extends Iscrizioneevento{

	private int codiceiscrizionedisciplina;
	
	private Disciplina disciplina;
	private Disciplinedisponibili disciplinedisponibili;
	public int getCodiceiscrizionedisciplina() {
		return codiceiscrizionedisciplina;
	}
	public void setCodiceiscrizionedisciplina(int codiceiscrizionedisciplina) {
		this.codiceiscrizionedisciplina = codiceiscrizionedisciplina;
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
	public Disciplinedisponibili getDisciplinedisponibili() {
		return disciplinedisponibili;
	}
	public void setDisciplinedisponibili(Disciplinedisponibili disciplinedisponibili) {
		this.disciplinedisponibili = disciplinedisponibili;
	}
	
	
}
