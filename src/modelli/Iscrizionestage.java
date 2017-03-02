package modelli;


import dao.IscrizionestageDAO;

public class Iscrizionestage {
	private int codiceiscrizionestage;
	private Stage stage;
	

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
