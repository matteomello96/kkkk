package modelli;

import dao.UtenteinattesaDAO;


public class Utenteinattesa extends Utentegenerico{
	
	private int codiceregistrazione;
	private Tipoutente tipoutente;
	


	public static Utenteinattesa CercaUtenteperCodice(int codiceregistrazione) {
		return UtenteinattesaDAO.getInstance().CercaperCodice(codiceregistrazione);
	}



	public int getCodiceregistrazione() {
		return codiceregistrazione;
	}



	public void setCodiceregistrazione(int codiceregistrazione) {
		this.codiceregistrazione = codiceregistrazione;
	}



	public Tipoutente getTipoutente() {
		return tipoutente;
	}



	public void setTipoutente(Tipoutente tipoutente) {
		this.tipoutente = tipoutente;
	}
	
	}