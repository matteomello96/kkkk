package modelli;



import dao.SpazioDAO;

public class Spazio {
  private String nomespazio;
  
public String getNomespazio() {
	return nomespazio;
}


public void setNomespazio(String nomespazio) {
	this.nomespazio = nomespazio;
}
public static Spazio CercaSpazioperNome(String nomespazio) {
	return SpazioDAO.getInstance().CercaperNome(nomespazio);
}


}
