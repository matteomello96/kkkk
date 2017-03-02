package modelli;

import dao.ResponsabilecentroDAO;


public class Responsabilecentro extends Utentegenerico{
	
	private int matricolaresponsabile;
	

public int getMatricolaistruttore() {
		return matricolaresponsabile;
	}

	public void setMatricolaresponsabile(int matricolaresponsabile) {
		this.matricolaresponsabile = matricolaresponsabile;
	}
	public static Responsabilecentro CercaIstruttoreperMatricola(int matricolaresponsabile) {
		return ResponsabilecentroDAO.getInstance().CercaperMatricola(matricolaresponsabile);
	}
	
	}