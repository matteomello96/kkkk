package modelli;

import java.io.IOException;

import dao.IscrizionedisciplinaDAO;


public class Iscrizionedisciplina extends Iscrizioneevento{

	private int codiceiscrizionedisciplina;
	
	
	private Disciplinedisponibili disciplinedisponibili;
	public int getCodiceiscrizionedisciplina() {
		return codiceiscrizionedisciplina;
	}
	public void setCodiceiscrizionedisciplina(int codiceiscrizionedisciplina) {
		this.codiceiscrizionedisciplina = codiceiscrizionedisciplina;
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

	public static Iscrizionedisciplina cercaIscrizionedisciplinaperModalitapagamento(Modalitapagamento modalitapagamento) throws IOException {
		return IscrizionedisciplinaDAO.getInstance().CercaperModalitapagamento(modalitapagamento);
	}
	
}
