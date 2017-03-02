package modelli;



import dao.LivelloDAO;

public class Livello {
  private String nomelivello;
  
public String getNomelivello() {
	return nomelivello;
}


public void setNomelivello(String nomelivello) {
	this.nomelivello = nomelivello;
}
public static Livello CercaLivelloperNome(String nomelivello) {
	return LivelloDAO.getInstance().CercaperNome(nomelivello);
}


}
