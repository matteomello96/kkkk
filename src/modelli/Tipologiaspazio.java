package modelli;

import dao.TipologiaspazioDAO;

public class Tipologiaspazio {
  private String Nometipologia;
  private Spazio spazio;
public String getNometipologia() {
	return Nometipologia;
}
public void setNometipologia(String nometipologia) {
	Nometipologia = nometipologia;
}
public Spazio getSpazio() {
	return spazio;
}
public void setSpazio(Spazio spazio) {
	this.spazio = spazio;
}

public static Tipologiaspazio CercaTipologiaperNome(String nometipologia) {
	return TipologiaspazioDAO.getInstance().CercaperNome(nometipologia);
}


  
}
