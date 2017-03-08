package modelli;

import dao.TesseratoDAO;


public class Tesserato extends Utentegenerico{
	
	private int matricolatesserato;
	

public int getMatricolatesserato() {
		return matricolatesserato;
	}

	public void setMatricolatesserato(int matricolatesserato) {
		this.matricolatesserato = matricolatesserato;
	}
	public static Tesserato CercaTesseratoperMatricola(int matricolatesserato) {
		return TesseratoDAO.getInstance().CercaperMatricola(matricolatesserato);
	}
	
	public boolean login()
	{
	  return TesseratoDAO.getInstance().TesseratoEsiste(this);
	}
}