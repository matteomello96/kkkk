package modelli;


import dao.IscrizionestageDAO;

public class Iscrizionestage extends Iscrizioneevento {
	private int codiceiscrizionestage;
	private Stage stage;
	//Manca il campo note note
	

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
public static Iscrizionestage CercaIscrizionestageperCodice(int codiceiscrizionestage) {
		return IscrizionestageDAO.getInstance().CercaperCodice(codiceiscrizionestage);
	}
}
