package modelli;

import dao.StageDAO;

public class Stage extends Evento {
    private int codicestage;

	public int getCodicestage() {
		return codicestage;
	}

	public void setCodicestage(int codicestage) {
		this.codicestage = codicestage;
	}
	
	public static Stage CercaStageperCodice(int codicestage) {
		return StageDAO.getInstance().CercaperCodice(codicestage);
	}
}
