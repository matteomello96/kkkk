package modelli;

import dao.GaraDAO;

public class Gara extends Evento {
    private int codicegara;

	public int getCodicegara() {
		return codicegara;
	}

	public void setCodicegara(int codicegara) {
		this.codicegara = codicegara;
	}
	
	public static Gara CercaGaraperCodice(int codicegara) {
		return GaraDAO.getInstance().CercaperCodice(codicegara);
	}
}
