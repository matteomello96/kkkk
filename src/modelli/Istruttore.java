package modelli;

import dao.IstruttoreDAO;


public class Istruttore extends Utentegenerico{
	
	private int matricolaistruttore;
	

public int getMatricolaistruttore() {
		return matricolaistruttore;
	}

	public void setMatricolaistruttore(int matricolaistruttore) {
		this.matricolaistruttore = matricolaistruttore;
	}
	public static Istruttore CercaIstruttoreperMatricola(int matricolaistruttore) {
		return IstruttoreDAO.getInstance().CercaperMatricola(matricolaistruttore);
	}
	
	}