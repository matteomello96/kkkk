package modelli;

import java.io.IOException;

import dao.StageDAO;

public class Stage extends Evento {
    private int codicestage;

	public int getCodicestage() {
		return codicestage;
	}

	public void setCodicestage(int codicestage) {
		this.codicestage = codicestage;
	}
	
	public static Stage CercaStageperCodice(int codicestage) throws IOException {
		return StageDAO.getInstance().CercaperCodice(codicestage);
	}
}
