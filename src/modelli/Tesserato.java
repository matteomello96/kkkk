package modelli;

import dao.TesseratoDAO;
import modelli.Utentegenerico;



public class Tesserato extends Utentegenerico{
	
	private int matricolatesserato;
	
	

public Tesserato (String username, String pass) {
	
    this.username=username;
    this.pass=pass;
	}

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
	
	class Tesseratologin{
		String username;
		String pass;
		
	};
}