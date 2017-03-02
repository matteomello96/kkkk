package modelli;



import dao.ModalitapagamentoDAO;;

public class Modalitapagamento {
  private String nomemodalita;
  
public String getNomelivello() {
	return nomemodalita;
}


public void setNomemodalita(String nomemodalita) {
	this.nomemodalita = nomemodalita;
}
public static Modalitapagamento CercaModalitaperNome(String nomemodalita) {
	return ModalitapagamentoDAO.getInstance().CercaperNome(nomemodalita);
}


}
