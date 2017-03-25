package modelli;


import java.io.IOException;

import dao.IscrizionestageDAO;

public class Iscrizionestage extends Iscrizioneevento {
	private int codiceiscrizionestage;
	private Stage stage;
   private String note;	

	public int getCodiceiscrizionestage() {
		return codiceiscrizionestage;
	}

	public void setCodiceiscrizionestage(int codiceiscrizionestage) {
		this.codiceiscrizionestage = codiceiscrizionestage;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
public static Iscrizionestage CercaIscrizionestageperCodice(int codiceiscrizionestage) throws IOException {
		return IscrizionestageDAO.getInstance().CercaperCodice(codiceiscrizionestage);
	}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}
}
